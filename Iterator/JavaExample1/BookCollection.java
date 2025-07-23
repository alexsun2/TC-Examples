// TC_TYPE: iterator 

package Iterator.JavaExample1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Aggregate class that holds a collection of books
 * Important to note: an iterator needs to implement the Iterator interface
 * (java.util.Iterator).
 * The iterable needs to implement the Iterable interface and provide an
 * iterator method.
 * If the class does not implement Iterable, it is not an iterable.
 */
public class BookCollection implements Iterable<Book> {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookIterator(books);
    }
}