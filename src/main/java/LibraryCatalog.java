package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryCatalog {
    private final List<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public boolean isBookAvailable(Book book) {
        return books.contains(book);
    }

    public List<Book> getAvailableBooks() {
        return Collections.unmodifiableList(books);
    }
}
