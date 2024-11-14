package test.java;

import main.java.Book;
import main.java.Library;
import main.java.LibraryReporter;
import main.java.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;
    private LibraryReporter reporter;
    private Book book1;
    private Book book2;
    private User student;
    private User teacher;

    @BeforeEach
    public void setUp() {
        // Inicializar la biblioteca y objetos de prueba
        library = new Library();
        reporter = new LibraryReporter(library);
        book1 = new Book("The Catcher in the Rye");
        book2 = new Book("1984");
        student = new User("Alice", "Student");
        teacher = new User("Bob", "Teacher");

        library.addBook(book1);
        library.addBook(book2);
        library.registerUser(student);
        library.registerUser(teacher);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("To Kill a Mockingbird");
        library.addBook(book3);
        assertTrue(library.getBooks().contains(book3), "La biblioteca debería contener el libro agregado");
    }

    @Test
    public void testRemoveBook() {
        library.removeBook(book1);
        assertFalse(library.getBooks().contains(book1), "La biblioteca no debería contener el libro eliminado");
    }

    @Test
    public void testRegisterUser() {
        User newUser = new User("Charlie", "Student");
        library.registerUser(newUser);
        assertTrue(library.getUsers().contains(newUser), "La biblioteca debería contener el usuario registrado");
    }

    @Test
    public void testBorrowBookForStudent() {
        boolean borrowed = library.borrowBook(student, book1);
        assertTrue(borrowed, "El estudiante debería poder tomar prestado el libro");
        assertFalse(library.getBooks().contains(book1), "El libro prestado no debería estar disponible en la biblioteca");
        assertTrue(student.getBorrowedBooks().contains(book1), "El libro debería aparecer en la lista de libros prestados del estudiante");
    }

    @Test
    public void testBorrowBookLimitForStudent() {
        library.borrowBook(student, book1);
        library.borrowBook(student, book2);
        Book book3 = new Book("Moby Dick");
        library.addBook(book3);

        boolean borrowed = library.borrowBook(student, book3);
        assertFalse(borrowed, "El estudiante no debería poder tomar prestado más libros que el límite permitido");
    }

    @Test
    public void testBorrowBookForTeacher() {
        boolean borrowed = library.borrowBook(teacher, book1);
        assertTrue(borrowed, "El profesor debería poder tomar prestado el libro");
        assertFalse(library.getBooks().contains(book1), "El libro prestado no debería estar disponible en la biblioteca");
        assertTrue(teacher.getBorrowedBooks().contains(book1), "El libro debería aparecer en la lista de libros prestados del profesor");
    }

    @Test
    public void testReturnBook() {
        library.borrowBook(student, book1);
        library.returnBook(student, book1);
        assertTrue(library.getBooks().contains(book1), "El libro devuelto debería estar disponible en la biblioteca");
        assertFalse(student.getBorrowedBooks().contains(book1), "El libro devuelto no debería estar en la lista de libros prestados del estudiante");
    }

    @Test
    public void testGenerateReport() {
        library.borrowBook(student, book1);
        String report = reporter.generateReport();
        assertTrue(report.contains("Available Books:"), "El reporte debería contener la sección de libros disponibles");
        assertTrue(report.contains("Borrowed Books:"), "El reporte debería contener la sección de libros prestados");
        assertTrue(report.contains("1984"), "El reporte debería listar el libro '1984' como disponible");
        assertTrue(report.contains("The Catcher in the Rye borrowed by Alice"), "El reporte debería mostrar que 'The Catcher in the Rye' fue tomado prestado por Alice");
    }
}