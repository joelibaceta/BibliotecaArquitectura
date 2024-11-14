package main.java;

import main.java.models.Book;
import main.java.models.User;

public class LibraryReporter {

    private Library library;

    public LibraryReporter(Library library) {
        this.library = library;
    }

    // Generar un reporte de la biblioteca
    public String generateReport() {
        StringBuilder report = new StringBuilder("Library Report\n");
        report.append("Available Books:\n");
        for (Book book : library.getBooks()) {
            report.append(book.getTitle()).append("\n");
        }
        report.append("\nBorrowed Books:\n");
        // TODO: Mejorar esta seccion
        for (User user : library.getUsers()) {
            for (Book borrowedBook : user.getBorrowedBooks()) {
                report.append(borrowedBook.getTitle()).append(" borrowed by ").append(user.getName()).append("\n");
            }
        }
        return report.toString();
    }
}
