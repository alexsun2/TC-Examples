// TC_TYPE: strategy

package Strategy.JavaExample1;

import java.util.List;

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
