// TC_TYPE: iterator 

package Iterator.JavaExample1;

import java.util.Iterator;
import java.util.List;

/**
 * Iterator class that knows how to traverse the collection
 * Important to note: an iterator needs to implement the Iterator interface
 * (java.util.Iterator). If the class does not implement the Iterator interface,
 * it is not an iterator.
 */
public class BookIterator implements Iterator<Book> {

    private List<Book> books;
    private int index = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Book next() {
        return books.get(index++);
    }
}
