package main.java;

import java.util.List;

public interface IUser {

    public boolean borrowBook(Book book);

    public void returnBook(Book book);

    public List<Book> getBorrowedBooks();

    public String getName();
}