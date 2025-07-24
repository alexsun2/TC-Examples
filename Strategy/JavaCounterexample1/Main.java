package Strategy.JavaCounterexample1;

import java.util.List;

/**
 * Demonstrates the use of map with a lambda transformation.
 * 
 * This is a simple functional transformation pipeline.
 * 
 * ❌ Why this is NOT the Strategy pattern:
 * - We're using a lambda expression inline, not a named "strategy" class.
 * - The function logic is ephemeral, not encapsulated in a reusable object.
 * - There is no polymorphic behavior or dynamic strategy switching.
 */
public class Main {
    public static void main(String[] args) {
        // A list of integers
        SimpleList<Integer> numbers = new SimpleList<>(List.of(1, 2, 3, 4, 5));

        // Transform each number into a string, using a lambda
        CommonListADT<String> stringList = numbers.map(n -> "Num: " + n);

        // Print the result
        if (stringList instanceof SimpleList<String> strList) {
            System.out.println(strList.getItems());
            // Output: [Num: 1, Num: 2, Num: 3, Num: 4, Num: 5]
        }
    }
}