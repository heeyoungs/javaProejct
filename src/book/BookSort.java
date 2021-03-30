package book;

import java.util.Comparator;

public class BookSort implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return a.getBookName().compareTo(b.getBookName());
    }
}
