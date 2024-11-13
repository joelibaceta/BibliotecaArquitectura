package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Agregar un libro a la biblioteca
    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    // Remover un libro de la biblioteca
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Registrar un usuario en la biblioteca
    public void registerUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    // Permitir que un usuario tome un libro prestado
    public boolean borrowBook(User user, Book book) {
        if (books.contains(book) && user.canBorrow()) {
            user.borrowBook(book);
            books.remove(book);
            return true;
        }
        return false;
    }

    // Permitir que un usuario devuelva un libro
    public void returnBook(User user, Book book) {
        if (!books.contains(book)) {
            user.returnBook(book);
            books.add(book);
        }
    }

    // Generar una lista de libros
    private void listBooks(StringBuilder report) {
        for (Book book : books) {
            report.append(book.getTitle()).append("\n");
        }
    }

    // Generar una lista de usuarios con los libros prestados
    private void listBooksPertUsers(StringBuilder report) {
        for (User user : users) {
            for (Book borrowedBook : user.getBorrowedBooks()) {
                report.append(borrowedBook.getTitle()).append(" borrowed by ").append(user.getName()).append("\n");
            }
        }
    }

    // Generar un reporte de la biblioteca
    public String generateReport() {
        StringBuilder report = new StringBuilder("Library Report\n");
        report.append("Available Books:\n");
        listBooks(report)
        report.append("\nBorrowed Books:\n");
        listBooksPertUsers(report)
        return report.toString();
    }

    // Método para verificar si un libro está disponible en la biblioteca
    public boolean isBookAvailable(Book book) {
        return books.contains(book);
    }

    // Obtener una lista inmutable de los libros
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    // Obtener una lista inmutable de los usuarios
    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}