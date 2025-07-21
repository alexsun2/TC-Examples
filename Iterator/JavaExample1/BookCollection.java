// TC_TYPE: iterator 

package Iterator.JavaExample1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Aggregate class that holds a collection of books
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