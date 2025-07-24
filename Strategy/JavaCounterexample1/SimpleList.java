package Strategy.JavaCounterexample1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * A simple implementation of CommonListADT using java.util.List internally.
 * 
 * The map function applies a transformation function to each element.
 * 
 * ❌ This is not the Strategy pattern:
 * - We are not encapsulating algorithms in named classes.
 * - We pass functions directly (lambdas), not interchangeable objects.
 * - There’s no context object switching between behaviors.
 */
public class SimpleList<T> implements CommonListADT<T> {
    private final List<T> items;

    public SimpleList(List<T> items) {
        this.items = items;
    }

    @Override
    public <R> CommonListADT<R> map(Function<T, R> converter) {
        List<R> result = new ArrayList<>();
        for (T item : items) {
            result.add(converter.apply(item));
        }
        return new SimpleList<>(result);
    }

    public List<T> getItems() {
        return items;
    }
}