package Decorator.JavaExample1;

/**
 * BaseService provides a simple implementation of the Service interface.
 * This service executes a task (simulated by a delay).
 */
public class BaseService implements Service {

    /**
     * Executes the base service operation, simulating a task with a delay.
     */
    @Override
    public void execute() {
        System.out.println("Executing base service...");
        try {
            // Simulate a delay of 1 second
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
