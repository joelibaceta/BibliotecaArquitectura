package main.java;

import java.util.ArrayList;
import java.util.List;

public class LoanAccount {
    private final List<Book> borrowedBooks;

    public LoanAccount() {
        this.borrowedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBook(Book book) {
        borrowedBooks.remove(book);
    }

    public int getNumberOfBorrowedBooks() {
        return borrowedBooks.size();
    }

    public boolean hasBook(Book book) {
        return borrowedBooks.contains(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
