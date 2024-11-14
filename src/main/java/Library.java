package main.java;

import main.java.models.Book;
import main.java.models.User;

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
        if (books.contains(book)) {
            if (user.canBorrow()) {
                user.borrowBook(book);
                books.remove(book);
                return true;
            }
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