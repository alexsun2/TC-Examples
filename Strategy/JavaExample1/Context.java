// TC_TYPE: strategy

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
