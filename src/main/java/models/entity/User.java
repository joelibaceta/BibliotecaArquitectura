package main.java.models.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String type; // "Student" or "Teacher"
    private List<Book> borrowedBooks;

    public User(String name, String type) {
        this.name = name;
        this.type = type;
        this.borrowedBooks = new ArrayList<>();
    }

    public void setName(String name) {
		this.name = name;
	}
    
    public String getName() {
        return name;
    }


	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
        return type;
    }
	
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }



//	public void borrowBook(Book book) {
//        borrowedBooks.add(book);
//    }
//
//    public void returnBook(Book book) {
//        borrowedBooks.remove(book);
//    }

    

    

    
}