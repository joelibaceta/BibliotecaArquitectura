package library;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import library.controller.LibraryController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LibraryApiTest {

    private final LibraryController libraryController = new LibraryController();

    private Javalin app = Javalin.create(config -> {
        config.showJavalinBanner = false; // Opcional: elimina el banner
    });

    public LibraryApiTest() {
        // Configurar rutas de prueba
        app.get("/api/books", libraryController::getAllBooks);
        app.post("/api/books", libraryController::addBook);
        app.delete("/api/books/:id", libraryController::removeBook);

        app.post("/api/users", libraryController::registerUser);

        app.post("/api/library/borrow", libraryController::borrowBook);
        app.post("/api/library/return", libraryController::returnBook);
        app.get("/api/library/report", libraryController::generateReport);
    }

    @Test
    void testAddAndRetrieveBooks() {
        JavalinTest.test(app, (server, client) -> {
            // Crear un libro
            String bookJson = "{\"id\":1,\"title\":\"1984\"}";
            var postResponse = client.post("/api/books", bookJson);
            assertThat(postResponse.code()).isEqualTo(201); // Verificar que se creó el libro

            // Obtener todos los libros
            var getResponse = client.get("/api/books");
            assertThat(getResponse.code()).isEqualTo(200);
            assertThat(getResponse.body().string()).contains("1984");
        });
    }

    @Test
    void testRegisterAndBorrowBook() {
        JavalinTest.test(app, (server, client) -> {
            // Registrar un usuario
            String userJson = "{\"id\":1,\"name\":\"Alice\",\"type\":\"Student\"}";
            var postUserResponse = client.post("/api/users", userJson);
            assertThat(postUserResponse.code()).isEqualTo(201); // Verificar registro exitoso

            // Crear un libro
            String bookJson = "{\"id\":2,\"title\":\"To Kill a Mockingbird\"}";
            client.post("/api/books", bookJson);

            // Prestar el libro
            var borrowResponse = client.post("/api/library/borrow", "userName=Alice&bookTitle=To Kill a Mockingbird");
            assertThat(borrowResponse.code()).isEqualTo(200);
            assertThat(borrowResponse.body().string()).contains("Alice borrowed To Kill a Mockingbird");

            // Generar reporte
            var reportResponse = client.get("/api/library/report");
            assertThat(reportResponse.code()).isEqualTo(200);
            assertThat(reportResponse.body().string()).contains("To Kill a Mockingbird borrowed by Alice");
        });
    }

    @Test
    void testBorrowLimitExceeded() {
        JavalinTest.test(app, (server, client) -> {
            // Registrar un usuario estudiante
            String userJson = "{\"id\":2,\"name\":\"Bob\",\"type\":\"Student\"}";
            client.post("/api/users", userJson);

            // Crear dos libros
            String book1Json = "{\"id\":3,\"title\":\"Book 1\"}";
            String book2Json = "{\"id\":4,\"title\":\"Book 2\"}";
            String book3Json = "{\"id\":5,\"title\":\"Book 3\"}";
            client.post("/api/books", book1Json);
            client.post("/api/books", book2Json);
            client.post("/api/books", book3Json);

            // Prestar los dos primeros libros
            client.post("/api/library/borrow", "userName=Bob&bookTitle=Book 1");
            client.post("/api/library/borrow", "userName=Bob&bookTitle=Book 2");

            // Intentar prestar un tercer libro (superando el límite de 2 libros para estudiantes)
            var borrowResponse = client.post("/api/library/borrow", "userName=Bob&bookTitle=Book 3");
            assertThat(borrowResponse.code()).isEqualTo(200);
            assertThat(borrowResponse.body().string()).contains("Bob could not borrow Book 3 (limit reached)");
        });
    }

    @Test
    void testReturnBook() {
        JavalinTest.test(app, (server, client) -> {
            // Registrar un usuario
            String userJson = "{\"id\":3,\"name\":\"Charlie\",\"type\":\"Teacher\"}";
            client.post("/api/users", userJson);

            // Crear un libro
            String bookJson = "{\"id\":6,\"title\":\"The Great Gatsby\"}";
            client.post("/api/books", bookJson);

            // Prestar el libro
            client.post("/api/library/borrow", "userName=Charlie&bookTitle=The Great Gatsby");

            // Devolver el libro
            var returnResponse = client.post("/api/library/return", "userName=Charlie&bookTitle=The Great Gatsby");
            assertThat(returnResponse.code()).isEqualTo(200);
            assertThat(returnResponse.body().string()).contains("Charlie returned The Great Gatsby");

            // Verificar que el libro está nuevamente disponible
            var getResponse = client.get("/api/books");
            assertThat(getResponse.body().string()).contains("The Great Gatsby");
        });
    }
}