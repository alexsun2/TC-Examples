#!/usr/bin/env python
# A slightly simpler version of circuit breaker, without the redis support.
import threading
import sys
from datetime import datetime, timedelta, timezone

STATE_CLOSED = "closed"
STATE_OPEN = "open"
STATE_HALF_OPEN = "half-open"
UTC = timezone.utc


class CircuitBreakerError(Exception):
    """Raised when circuit breaker is open and calls are blocked."""


class CircuitBreakerStorage:
    """Simple storage interface for state and failure count."""

    def __init__(self, state: str = STATE_CLOSED):
        self._state = state
        self._fail_counter = 0
        self._opened_at = None

    @property
    def state(self):
        return self._state

    @state.setter
    def state(self, value: str):
        self._state = value

    def increment_counter(self):
        self._fail_counter += 1

    def reset_counter(self):
        self._fail_counter = 0

    @property
    def counter(self):
        return self._fail_counter

    @property
    def opened_at(self):
        return self._opened_at

    @opened_at.setter
    def opened_at(self, value: datetime):
        self._opened_at = value


class CircuitBreakerState:
    def __init__(self, breaker, name):
        self._breaker = breaker
        self._name = name

    @property
    def name(self):
        return self._name

    def call(self, func, *args, **kwargs):
        self.before_call(func, *args, **kwargs)
        try:
            result = func(*args, **kwargs)
        except Exception as exc:
            self._handle_error(exc)
        else:
            self._handle_success()
            return result

    def _handle_error(self, exc):
        self._breaker._state_storage.increment_counter()
        if self._breaker.fail_counter >= self._breaker.fail_max:
            self._breaker.open()
            raise CircuitBreakerError("Failures threshold reached, circuit breaker opened").with_traceback(sys.exc_info()[2])
        raise exc

    def _handle_success(self):
        self._breaker._state_storage.reset_counter()

    def before_call(self, func, *args, **kwargs):
        pass


class CircuitClosedState(CircuitBreakerState):
    def __init__(self, breaker):
        super().__init__(breaker, STATE_CLOSED)


class CircuitOpenState(CircuitBreakerState):
    def __init__(self, breaker):
        super().__init__(breaker, STATE_OPEN)

    def before_call(self, func, *args, **kwargs):
        timeout = timedelta(seconds=self._breaker.reset_timeout)
        opened_at = self._breaker._state_storage.opened_at
        if opened_at and datetime.now(UTC) < opened_at + timeout:
            raise CircuitBreakerError("Circuit breaker is open, timeout not elapsed yet.")
        self._breaker.half_open()


class CircuitHalfOpenState(CircuitBreakerState):
    def __init__(self, breaker):
        super().__init__(breaker, STATE_HALF_OPEN)

    def _handle_error(self, exc):
        self._breaker.open()
        raise CircuitBreakerError("Trial call failed, circuit breaker opened").with_traceback(sys.exc_info()[2])

    def _handle_success(self):
        self._breaker.close()


class CircuitBreaker:
    def __init__(self, fail_max=5, reset_timeout=60):
        self._lock = threading.RLock()
        self.fail_max = fail_max
        self.reset_timeout = reset_timeout
        self._state_storage = CircuitBreakerStorage()
        self._state = CircuitClosedState(self)

    @property
    def fail_counter(self):
        return self._state_storage.counter

    @property
    def current_state(self):
        return self._state_storage.state

    @property
    def state(self):
        # Keep _state instance synced with storage
        if self._state.name != self.current_state:
            self._state = self._create_state(self.current_state)
        return self._state

    def _create_state(self, state_name):
        if state_name == STATE_CLOSED:
            return CircuitClosedState(self)
        elif state_name == STATE_OPEN:
            return CircuitOpenState(self)
        elif state_name == STATE_HALF_OPEN:
            return CircuitHalfOpenState(self)
        else:
            raise ValueError(f"Unknown state: {state_name}")

    def call(self, func, *args, **kwargs):
        with self._lock:
            return self.state.call(func, *args, **kwargs)

    def open(self):
        with self._lock:
            self._state_storage.state = STATE_OPEN
            self._state_storage.opened_at = datetime.now(UTC)

    def half_open(self):
        with self._lock:
            self._state_storage.state = STATE_HALF_OPEN

    def close(self):
        with self._lock:
            self._state_storage.state = STATE_CLOSED
            self._state_storage.reset_counter()
            self._state_storage.opened_at = None

    def __call__(self, func):
        def wrapper(*args, **kwargs):
            return self.call(func, *args, **kwargs)
        return wrapper
