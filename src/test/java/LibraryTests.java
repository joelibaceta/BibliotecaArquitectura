package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTests {
    private Library library;
    private LibraryCatalog catalog;
    private PolicysBorrow politicaPrestamo;
    private User alumno;
    private User profesor;
    private Book book1, book2, book3, book4;

    @BeforeEach
    void setUp() {
        catalog = new LibraryCatalog();
        politicaPrestamo = new BorrowLimitPolicy();
        library = new Library(catalog, politicaPrestamo);

        alumno = new Student("Martin");
        profesor = new Teacher("Tim Cook");

        book1 = new Book("Arquitectura Empresarial TOGAF");
        book2 = new Book("Principios SOLID");
        book3 = new Book("Arquitectura de Computadoras");
        book4 = new Book("Patrones de Diseño");

        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);
        catalog.addBook(book4);

        library.registerUser(alumno);
        library.registerUser(profesor);
    }

    @Test
    void testAlumnoBorrowLimit() {
        assertTrue(library.borrowBook(alumno, book1));
        assertTrue(library.borrowBook(alumno, book2));
        assertTrue(library.borrowBook(alumno, book3));
        assertFalse(library.borrowBook(alumno, book4));
    }

    @Test
    void testProfesorBorrowLimit() {
        assertTrue(library.borrowBook(profesor, book1));
        assertTrue(library.borrowBook(profesor, book2));
        assertTrue(library.borrowBook(profesor, book3));
        assertTrue(library.borrowBook(profesor, book4));

        Book extraBook = new Book("Principios SOLID");
        catalog.addBook(extraBook);
        assertTrue(library.borrowBook(profesor, extraBook));
    }

    @Test
    void testReturnBook() {
        library.borrowBook(alumno, book1);
        library.returnBook(alumno, book1);
        assertTrue(catalog.isBookAvailable(book1));
    }
}
