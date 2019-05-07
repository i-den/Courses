package Library;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library implements Iterable<Book> {

    private Book[] books;

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    @Override
    public void forEach(Consumer<? super Book> action) {
        for (Book book : books) {
            action.accept(book);
        }
    }

    private class LibIterator implements Iterator<Book> {

        private int currIndex;

        LibIterator() {
            currIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return books.length > currIndex;
        }

        @Override
        public Book next() {
            return books[currIndex++];
        }
    }
}
