// TC_TYPE: circuit_breaker

package JavaExample1;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

// Custom exception when the circuit is open
class CircuitBreakerOpenException extends RuntimeException {
    public CircuitBreakerOpenException(String message) {
        super(message);
    }
}

// The core Circuit Breaker class
public class CircuitBreaker1 {

    // Circuit states
    private enum State { CLOSED, OPEN, HALF_OPEN }

    private State state = State.CLOSED;
    private int failureCount = 0;
    private final int failureThreshold;
    private final Duration resetTimeout;
    private Instant lastFailureTime;

    // Constructor: configure failure limit and timeout duration
    public CircuitBreaker1(int failureThreshold, Duration resetTimeout) {
        this.failureThreshold = failureThreshold;
        this.resetTimeout = resetTimeout;
    }

    // The method that "wraps" protected logic
    public <T> T call(Callable<T> task) throws Exception {
        // If open, check whether timeout has passed
        if (state == State.OPEN) {
            if (Instant.now().isAfter(lastFailureTime.plus(resetTimeout))) {
                // Allow a trial call
                state = State.HALF_OPEN;
            } else {
                // Still within timeout → block the call
                throw new CircuitBreakerOpenException("Circuit is open. Try again later.");
            }
        }

        try {
            // Attempt the actual operation
            T result = task.call();

            // If successful in HALF_OPEN, close the circuit
            if (state == State.HALF_OPEN) {
                state = State.CLOSED;
                failureCount = 0;
            }

            return result;
        } catch (Exception ex) {
            // On failure, update failure count and possibly open the circuit
            failureCount++;
            lastFailureTime = Instant.now();

            if (failureCount >= failureThreshold) {
                state = State.OPEN;
            }

            throw ex; // Rethrow the original exception
        }
    }
}

