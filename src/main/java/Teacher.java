package main.java;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements IUser {
    private String name;
    private List<Book> borrowedBooks;

    public Teacher(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean borrowBook(Book book) {
        boolean result=false;
        if (borrowedBooks.size()<5){
            borrowedBooks.add(book);
            result=true;
        }

        return result;
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
