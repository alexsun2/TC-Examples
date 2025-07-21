// TC_TYPE: iterator 

package Iterator.JavaExample1;

import java.util.Iterator;

/**
 * Iterator Design Pattern Example
 *
 * This example shows how to implement the Iterator pattern to traverse a collection
 * without exposing its underlying structure.
 */

public class Main {
    public static void main(String[] args) {
        // Create a book collection
        BookCollection collection = new BookCollection();
        collection.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        collection.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        collection.addBook(new Book("1984", "George Orwell"));
        collection.addBook(new Book("Pride and Prejudice", "Jane Austen"));

        // Iterate through the collection using the iterator
        System.out.println("Books in the collection:");
        for (Book book : collection) {
            System.out.println("- " + book);
        }

        // Alternatively, using the iterator explicitly
        System.out.println("\nBooks again (using iterator explicitly):");
        Iterator<Book> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("- " + book);
        }
    }
}
