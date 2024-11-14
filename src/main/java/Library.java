package main.java;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final LibraryCatalog catalog;
    private final List<User> usuarios;
    private final PolicysBorrow politicaPrestamo;

    public Library(LibraryCatalog catalog, PolicysBorrow politicaPrestamo) {
        this.catalog = catalog;
        this.usuarios = new ArrayList<>();
        this.politicaPrestamo = politicaPrestamo;
    }

    public void registerUser(User usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public boolean borrowBook(User usuario, Book book) {
        if (catalog.isBookAvailable(book) && politicaPrestamo.canBorrow(usuario)) {
            usuario.getLoanAccount().addBook(book);
            catalog.removeBook(book);
            return true;
        }
        return false;
    }

    public void returnBook(User usuario, Book book) {
        usuario.getLoanAccount().removeBook(book);
        catalog.addBook(book);
    }

    public LibraryCatalog getCatalog() {
        return catalog;
    }

    public List<User> getUsuarios() {
        return usuarios;
    }
}
