package main.java;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;
    private List<Book> borrowedBooks;
    private BorrowPolicy borrowPolicy;

    public User(String name, BorrowPolicy borrowPolicy) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.borrowPolicy = borrowPolicy;
    }

    public boolean canBorrow() {
        return borrowPolicy.canBorrow(borrowedBooks);
    }

    public void borrowBook(Book book) {
        if (canBorrow()) {
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }
}