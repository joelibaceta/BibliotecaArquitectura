package library;

import io.javalin.Javalin;
import library.controller.LibraryController;

public class MainApplication {
    public static void main(String[] args) {
        // Crear la instancia de Javalin
        Javalin app = Javalin.create().start(8000);

        // Crear una instancia del controlador
        LibraryController libraryController = new LibraryController();

        // Definir las rutas
        app.get("/api/books", libraryController::getAllBooks);               // Obtener todos los libros
        app.post("/api/books", libraryController::addBook);                  // Agregar un libro
        app.delete("/api/books/{id}", libraryController::removeBook);        // Eliminar un libro por ID

        app.post("/api/users", libraryController::registerUser);             // Registrar un usuario

        app.post("/api/library/borrow", libraryController::borrowBook);      // Tomar un libro prestado
        app.post("/api/library/return", libraryController::returnBook);      // Devolver un libro
        app.get("/api/library/report", libraryController::generateReport);   // Generar un reporte
    }
}