package library.repository;

import library.model.User;
import library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Long bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public Book getBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }
}