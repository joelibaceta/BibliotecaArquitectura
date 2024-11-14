package main.java.models.service;

import main.java.models.entity.Book;
import main.java.models.entity.User;
import main.java.models.localdata.LibraryLocalData;

public class BookServiceImpl implements IBookService{
	
	LibraryLocalData libraryLocalData;
	
	
	BookServiceImpl( LibraryLocalData libraryLocalData){
		this.libraryLocalData = libraryLocalData;
	}
	@Override
	public void addBook(Book book) {
		
		if (!this.libraryLocalData.getBooks().contains(book)) {
			this.libraryLocalData.getBooks().add(book);
		}
			
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBook(Book book) {
		
		this.libraryLocalData.getBooks().remove(book);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean borrowBookByUser(User user, Book book) {
		if (this.libraryLocalData.getBooks().contains(book)) {
          if (user.getType().equals("Student") && user.getBorrowedBooks().size() < 2) {
              user.borrowBook(book);
              this.libraryLocalData.getBooks().remove(book);
              return true;
          } else if (user.getType().equals("Teacher") && user.getBorrowedBooks().size() < 5) {
              user.borrowBook(book);
              this.libraryLocalData.getBooks().remove(book);
              return true;
          }
      }
      return false;
	}

	@Override
	public void returnBookByUser(User user, Book book) {
		
		if (!this.libraryLocalData.getBooks().contains(book)) {
	          user.returnBook(book);
	          this.libraryLocalData.getBooks().add(book);
	      }
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBookAvailable(Book book) {
		return this.libraryLocalData.getBooks().contains(book);
	}

}
