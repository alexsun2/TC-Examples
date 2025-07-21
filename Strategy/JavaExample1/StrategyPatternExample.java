package Strategy.JavaExample1;

import java.util.Arrays;
import java.util.List;

/**
 * The Context defines the interface of interest to clients.
 */
class Context {
    private Strategy strategy;

    /**
     * The Context accepts a Strategy through the constructor. The Strategy defines
     * the algorithm that will be used by the Context.
     * 
     * @param strategy The strategy object used by the context.
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Gets the current strategy.
     * 
     * @return The current strategy object.
     */
    public Strategy getStrategy() {
        return this.strategy;
    }

    /**
     * Sets a new strategy, allowing the context to change strategies at runtime.
     * 
     * @param strategy The new strategy to be used by the context.
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * The Context delegates work to the Strategy object instead of implementing
     * multiple versions of the algorithm on its own. It allows the algorithm
     * to be changed dynamically.
     */
    public void doSomeBusinessLogic() {
        System.out.println("Context: Sorting data using the strategy (not sure how it'll do it)");
        List<String> result = this.strategy.doAlgorithm(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println(String.join(",", result));
    }
}

/**
 * The Strategy interface declares an operation common to all supported versions
 * of some algorithm. Concrete strategies implement this interface to define
 * specific algorithm behavior.
 */
interface Strategy {

    /**
     * Defines the algorithm that will be executed.
     * 
     * @param data The data to be processed by the algorithm.
     * @return The result of the algorithm.
     */
    List<String> doAlgorithm(List<String> data);
}

/**
 * ConcreteStrategyA implements the sorting algorithm by sorting the data in
 * ascending order.
 */
class ConcreteStrategyA implements Strategy {

    /**
     * Sorts the given data in ascending order.
     * 
     * @param data The data to be sorted.
     * @return The sorted data.
     */
    @Override
    public List<String> doAlgorithm(List<String> data) {
        data.sort(String::compareTo);
        return data;
    }
}

/**
 * ConcreteStrategyB implements the sorting algorithm by sorting the data in
 * descending order.
 */
class ConcreteStrategyB implements Strategy {

    /**
     * Sorts the given data in descending order.
     * 
     * @param data The data to be sorted.
     * @return The sorted data in descending order.
     */
    @Override
    public List<String> doAlgorithm(List<String> data) {
        data.sort((a, b) -> b.compareTo(a));
        return data;
    }
}

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
