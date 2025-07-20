package Decorator;

/**
 * LoggingDecorator is a decorator that logs the execution time of the wrapped
 * Service.
 * It adds additional functionality to the execute method without modifying the
 * BaseService.
 */
public class LoggingDecorator implements Service {
    private final Service wrappedService;

    /**
     * Constructs a LoggingDecorator that wraps a Service.
     * 
     * @param service the Service to decorate
     */
    public LoggingDecorator(Service service) {
        this.wrappedService = service; // Store the service to be decorated
    }

    /**
     * Executes the wrapped service and logs the time taken for execution.
     */
    @Override
    public void execute() {
        long startTime = System.currentTimeMillis(); // Start time
        wrappedService.execute(); // Delegate the execution to the wrapped service
        long endTime = System.currentTimeMillis(); // End time

        // Log the execution time
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
    }
}
