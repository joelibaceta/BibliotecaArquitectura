package main.java.models.service;

import main.java.models.entity.Book;
import main.java.models.entity.User;

public interface IBookService {
	
	public void addBook(Book book);
	public void removeBook(Book book);
	public boolean borrowBookByUser(User user, Book book);     //borrowBook
	public void returnBookByUser(User user, Book book);   //returnBook
	public boolean isBookAvailable(Book book);

}
