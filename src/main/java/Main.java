package main.java;

public class Main {

    public static void main(String[] args) {
        // Crear el catálogo de la biblioteca y la política de préstamo
        LibraryCatalog catalog = new LibraryCatalog();
        PolicysBorrow politicaPrestamo = new BorrowLimitPolicy();

        // Crear la instancia de la biblioteca con el catálogo y la política de préstamo
        Library library = new Library(catalog, politicaPrestamo);

        // Crear libros
        Book book1 = new Book("The Catcher in the Rye");
        Book book2 = new Book("To Kill a Mockingbird");
        Book book3 = new Book("1984");
        Book book4 = new Book("Moby Dick");
        Book book5 = new Book("War and Peace");

        // Agregar libros al catálogo de la biblioteca
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);
        catalog.addBook(book4);
        catalog.addBook(book5);

        // Crear usuarios de tipo Alumno y Profesor
        User alumno = new Student("Alice");
        User profesor = new Teacher("Bob");

        // Registrar los usuarios en la biblioteca
        library.registerUser(alumno);
        library.registerUser(profesor);

        // Préstamos para Alumno
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

        // Préstamos para Profesor
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

        // Devolución de un libro por el Alumno
        System.out.println("\nDevolución de libros:");
        library.returnBook(alumno, book1);
        System.out.println(alumno.getName() + " ha devuelto: " + book1.getTitle());

        // Mostrar disponibilidad del libro devuelto
        System.out.println("\nDisponibilidad de libros después de la devolución:");
        System.out.println(book1.getTitle() + " está disponible: " + catalog.isBookAvailable(book1));
    }
}
