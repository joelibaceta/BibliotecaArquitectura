package main.java;

import main.java.models.Book;
import main.java.models.Student;
import main.java.models.Teacher;
import main.java.models.User;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de la biblioteca
        Library library = new Library();
        LibraryReporter reporter = new LibraryReporter(library);

        // Crear algunos libros
        Book book1 = new Book("The Catcher in the Rye");
        Book book2 = new Book("To Kill a Mockingbird");
        Book book3 = new Book("1984");

        // Agregar libros a la biblioteca
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Crear algunos usuarios
        Student student = new Student("Alice");
        Teacher teacher = new Teacher("Bob");

        // Registrar usuarios en la biblioteca
        library.registerUser(student);
        library.registerUser(teacher);

        // Realizar algunos préstamos
        System.out.println("Préstamos de libros:");
        if (library.borrowBook(student, book1)) {
            System.out.println(student.getName() + " ha tomado prestado: " + book1.getTitle());
        } else {
            System.out.println(student.getName() + " no pudo tomar prestado: " + book1.getTitle());
        }

        if (library.borrowBook(teacher, book2)) {
            System.out.println(teacher.getName() + " ha tomado prestado: " + book2.getTitle());
        } else {
            System.out.println(teacher.getName() + " no pudo tomar prestado: " + book2.getTitle());
        }

        // Intentar tomar otro libro para el estudiante, hasta el límite
        if (library.borrowBook(student, book3)) {
            System.out.println(student.getName() + " ha tomado prestado: " + book3.getTitle());
        } else {
            System.out.println(student.getName() + " no pudo tomar prestado: " + book3.getTitle() + " (límite alcanzado)");
        }

        // Devolver un libro
        System.out.println("\nDevolución de libros:");
        library.returnBook(student, book1);
        System.out.println(student.getName() + " ha devuelto: " + book1.getTitle());

        // Generar y mostrar el reporte de la biblioteca
        System.out.println("\nReporte de la Biblioteca:");
        System.out.println(reporter.generateReport());
    }
}