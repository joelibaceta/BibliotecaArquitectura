package main.java.models.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

	private List<Book> books;
//    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
//        this.users = new ArrayList<>();
    }
    
    public void setBooks(List<Book> books) {
    	this.books = books;
    }
    
    // Obtener una lista inmutable de los libros
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    
    
    
    
    
    
    
    
    
    

//    // Agregar un libro a la biblioteca
//    public void addBook(Book book) {  OK  OK
//        if (!books.contains(book)) {
//            books.add(book);
//        }
//    }
//
//    // Remover un libro de la biblioteca
//    public void removeBook(Book book) { OK
//        books.remove(book);
//    }
//
//    // Registrar un usuario en la biblioteca
//    public void registerUser(User user) {  //ok
//        if (!users.contains(user)) {
//            users.add(user);
//        }
//    }
//
//    // Permitir que un usuario tome un libro prestado
//    public boolean borrowBook(User user, Book book) {  OK
//        if (books.contains(book)) {
//            if (user.getType().equals("Student") && user.getBorrowedBooks().size() < 2) {
//                user.borrowBook(book);
//                books.remove(book);
//                return true;
//            } else if (user.getType().equals("Teacher") && user.getBorrowedBooks().size() < 5) {
//                user.borrowBook(book);
//                books.remove(book);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Permitir que un usuario devuelva un libro
//    public void returnBook(User user, Book book) {  OK
//        if (!books.contains(book)) {
//            user.returnBook(book);
//            books.add(book);
//        }
//    }
//
//    // Generar un reporte de la biblioteca
//    public String generateReport() {
//        StringBuilder report = new StringBuilder("Library Report\n");
//        report.append("Available Books:\n");
//        for (Book book : books) {
//            report.append(book.getTitle()).append("\n");
//        }
//        report.append("\nBorrowed Books:\n");
//        for (User user : users) {
//            for (Book borrowedBook : user.getBorrowedBooks()) {
//                report.append(borrowedBook.getTitle()).append(" borrowed by ").append(user.getName()).append("\n");
//            }
//        }
//        return report.toString();
//    }
//
//    // Método para verificar si un libro está disponible en la biblioteca
//    public boolean isBookAvailable(Book book) {   OK
//        return books.contains(book);
//    }
//
//   
//    // Obtener una lista inmutable de los usuarios
//    public List<User> getUsers() {   OK
//        return Collections.unmodifiableList(users);
//    }
}