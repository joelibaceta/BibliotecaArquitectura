package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryCore {
    private List<Book> books;
    private List<User> users;

    public LibraryCore() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public boolean borrowBook(User user, Book book, BorrowPolicy policy) {
        if (books.contains(book) && policy.canBorrow(user, book)) {
            user.borrowBook(book);
            books.remove(book);
            return true;
        }
        return false;
    }

    public void returnBook(User user, Book book) {
        if (!books.contains(book)) {
            user.returnBook(book);
            books.add(book);
        }
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}