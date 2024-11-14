package main.java;

import java.util.ArrayList;
import java.util.List;

public class Student implements IUser {
    private String name;
    private List<Book> borrowedBooks;

    public Student(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean borrowBook(Book book) {
        boolean result=false;
        if (borrowedBooks.size()<2){
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
