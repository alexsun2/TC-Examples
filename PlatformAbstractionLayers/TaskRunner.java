// TC_TYPE: adapter

package PlatformAbstractionLayers;

// Core logic depending only on the abstraction
public class TaskRunner {
    private final Operation operation;

    public TaskRunner(Operation operation) {
        this.operation = operation;
    }

    public void run() {
        operation.execute();
    }
}