"""
Iterator Design Pattern Example

This example shows how to implement the Iterator pattern to traverse a collection
without exposing its underlying structure.
"""

class Book:
    def __init__(self, title, author):
        self.title = title
        self.author = author
    
    def __str__(self):
        return f"{self.title} by {self.author}"

class BookCollection:
    """Aggregate class that holds a collection of books"""
    def __init__(self):
        self._books = []
    
    def add_book(self, book):
        self._books.append(book)
    
    def __iter__(self):
        return BookIterator(self._books)

class BookIterator:
    """Iterator class that knows how to traverse the collection"""
    def __init__(self, books):
        self._books = books
        self._index = 0
    
    def __next__(self):
        if self._index < len(self._books):
            book = self._books[self._index]
            self._index += 1
            return book
        else:
            raise StopIteration

# Client code
if __name__ == "__main__":
    # Create a book collection
    collection = BookCollection()
    collection.add_book(Book("The Great Gatsby", "F. Scott Fitzgerald"))
    collection.add_book(Book("To Kill a Mockingbird", "Harper Lee"))
    collection.add_book(Book("1984", "George Orwell"))
    collection.add_book(Book("Pride and Prejudice", "Jane Austen"))
    
    # Iterate through the collection using the iterator
    print("Books in the collection:")
    for book in collection:
        print(f"- {book}")
    
    # Alternatively, using the iterator explicitly
    print("\nBooks again (using iterator explicitly):")
    iterator = iter(collection)
    while True:
        try:
            book = next(iterator)
            print(f"- {book}")
        except StopIteration:
            break