package main.java;

public class Main {

    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        PolicysBorrow politicaPrestamo = new BorrowLimitPolicy();

        Library library = new Library(catalog, politicaPrestamo);

        Book book1 = new Book("Arquitectura Empresarial TOGAF");
        Book book2 = new Book("Principios SOLID");
        Book book3 = new Book("Arquitectura de Computadoras");
        Book book4 = new Book("Codigo Limpio");
        Book book5 = new Book("Algoritmos");

        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);
        catalog.addBook(book4);
        catalog.addBook(book5);

        User alumno = new Student("Martin");
        User profesor = new Teacher("Tim Cook");

        library.registerUser(alumno);
        library.registerUser(profesor);

        System.out.println("Préstamos para Alumno:");
        if (library.borrowBook(alumno, book1)) {
            System.out.println(alumno.getName() + " ha tomado prestado: " + book1.getTitle());
        }
        if (library.borrowBook(alumno, book2)) {
            System.out.println(alumno.getName() + " ha tomado prestado: " + book2.getTitle());
        }
        if (library.borrowBook(alumno, book3)) {
            System.out.println(alumno.getName() + " ha tomado prestado: " + book3.getTitle());
        }
        if (!library.borrowBook(alumno, book4)) {
            System.out.println(alumno.getName() + " no pudo tomar prestado: " + book4.getTitle() + " (límite alcanzado)");
        }

        System.out.println("\nPréstamos para Profesor:");
        if (library.borrowBook(profesor, book1)) {
            System.out.println(profesor.getName() + " ha tomado prestado: " + book1.getTitle());
        }
        if (library.borrowBook(profesor, book2)) {
            System.out.println(profesor.getName() + " ha tomado prestado: " + book2.getTitle());
        }
        if (library.borrowBook(profesor, book3)) {
            System.out.println(profesor.getName() + " ha tomado prestado: " + book3.getTitle());
        }
        if (library.borrowBook(profesor, book4)) {
            System.out.println(profesor.getName() + " ha tomado prestado: " + book4.getTitle());
        }
        if (library.borrowBook(profesor, book5)) {
            System.out.println(profesor.getName() + " ha tomado prestado: " + book5.getTitle());
        }

        System.out.println("\nDevolución de libros:");
        library.returnBook(alumno, book1);
        System.out.println(alumno.getName() + " ha devuelto: " + book1.getTitle());

        System.out.println("\nDisponibilidad de libros después de la devolución:");
        System.out.println(book1.getTitle() + " está disponible: " + catalog.isBookAvailable(book1));

        LibraryReport reportGenerator = new LibraryReport();
        String report = reportGenerator.generateReport(library);
        System.out.println(report);
    }
}
