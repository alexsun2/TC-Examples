// TC_TYPE: strategy

package Strategy.JavaExample1;

import java.util.List;

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
