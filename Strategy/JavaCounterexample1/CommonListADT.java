package Strategy.JavaCounterexample1;

import java.util.function.Function;

/**
 * A generic interface representing a list with a map operation.
 * 
 * The map method takes a Function<T, R> and returns a new CommonListADT<R>.
 * 
 * This interface supports functional-style transformations, but it does not
 * define or manage interchangeable strategy objects, so it does NOT use the Strategy pattern.
 */
public interface CommonListADT<T> {
    <R> CommonListADT<R> map(Function<T, R> converter);
}