package library.model;

import library.policy.LoanPolicy;
import java.util.ArrayList;
import java.util.List;
import library.model.Book;

public class User {
    private Long id;
    private String name;
    private String type;
    private List<Book> borrowedBooks;
    private LoanPolicy loanPolicy;

    public User() {
        this.borrowedBooks = new ArrayList<>();
    }

    public User(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.borrowedBooks = new ArrayList<>();
        this.loanPolicy = LoanPolicy.createPolicy(type);
    }

    public Long getId() {
        return id;
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

    public boolean canBorrow() {
        return loanPolicy.canBorrow(borrowedBooks.size());
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}