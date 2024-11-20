package core;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String type; // Ejemplo: "Student", "Teacher"
    private List<Book> borrowedBooks;

    public User(String name, String type) {
        this.name = name;
        this.type = type;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}