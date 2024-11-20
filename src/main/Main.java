package main;

import core.Book;
import core.BorrowPolicy;
import core.LibraryCore;
import core.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryCore library = new LibraryCore();

        // Cargar plugins dinámicamente
        PluginLoader pluginLoader = new PluginLoader();
        List<BorrowPolicy> policies = pluginLoader.loadPlugins();

        if (policies.isEmpty()) {
            System.out.println("No se cargaron políticas de préstamo.");
            return;
        }

        // Crear libros
        Book book1 = new Book("The Catcher in the Rye");
        Book book2 = new Book("To Kill a Mockingbird");
        library.addBook(book1);
        library.addBook(book2);

        // Crear usuarios
        User student = new User("Alice", "Student");
        library.registerUser(student);

        // Aplicar la política adecuada
        BorrowPolicy studentPolicy = policies.stream()
                .filter(policy -> policy.getClass().getSimpleName().equals("StudentBorrowPolicy"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró política para estudiantes."));

        // Intentar tomar un libro prestado
        if (library.borrowBook(student, book1, studentPolicy)) {
            System.out.println(student.getName() + " tomó prestado: " + book1.getTitle());
        } else {
            System.out.println(student.getName() + " no pudo tomar prestado: " + book1.getTitle());
        }
    }
}