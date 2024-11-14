package main.java;

import java.util.List;

public class LibraryReport {

    public String generateReport(Library library) {
        StringBuilder report = new StringBuilder("Reporte de la Biblioteca\n");

        report.append("Libros disponibles:\n");
        for (Book book : library.getCatalog().getAvailableBooks()) {
            report.append("- ").append(book.getTitle()).append("\n");
        }

        report.append("\nLibros prestados:\n");
        for (User usuario : library.getUsuarios()) {
            List<Book> borrowedBooks = usuario.getLoanAccount().getBorrowedBooks();

            if (!borrowedBooks.isEmpty()) {
                report.append(formatUserBorrowedBooks(usuario, borrowedBooks));
            }
        }

        return report.toString();
    }

    private String formatUserBorrowedBooks(User usuario, List<Book> borrowedBooks) {
        StringBuilder userReport = new StringBuilder();
        userReport.append(usuario.getName()).append(" ha tomado prestado:\n");

        for (Book borrowedBook : borrowedBooks) {
            userReport.append("   - ").append(borrowedBook.getTitle()).append("\n");
        }

        return userReport.toString();
    }

}
