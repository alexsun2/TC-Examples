// TC_TYPE: strategy

package Strategy.JavaExample1;

/**
 * Client code demonstrates how the Strategy Pattern allows clients to
 * interchange strategies at runtime. The client can choose a different
 * sorting strategy dynamically.
 */
public class StrategyPatternExample {

    /**
     * The client code demonstrates how different strategies can be applied
     * to the context. The context is able to switch between strategies
     * without needing to change its own code.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // The client code picks a concrete strategy and passes it to the context.
        // The client should be aware of the differences between strategies
        // in order to make the right choice.

        Context context = new Context(new ConcreteStrategyA());
        System.out.println("Client: Strategy is set to normal sorting.");
        context.doSomeBusinessLogic();
        System.out.println();

        System.out.println("Client: Strategy is set to reverse sorting.");
        context.setStrategy(new ConcreteStrategyB());
        context.doSomeBusinessLogic();
    }
}
