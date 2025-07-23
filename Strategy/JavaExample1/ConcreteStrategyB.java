// TC_TYPE: strategy

package Strategy.JavaExample1;

import java.util.List;

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