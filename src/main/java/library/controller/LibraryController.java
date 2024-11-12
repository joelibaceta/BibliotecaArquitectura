package library.controller;

import library.model.Book;
import library.model.User;
import library.service.LibraryService;

import io.javalin.http.Context;

public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController() {
        this.libraryService = new LibraryService();
    }

    public void getAllBooks(Context ctx) {
        ctx.json(libraryService.getAllBooks());
    }

    public void addBook(Context ctx) {
        Book book = ctx.bodyAsClass(Book.class);
        libraryService.addBook(book);
        ctx.status(201);
    }

    public void removeBook(Context ctx) {
        Long bookId = Long.valueOf(ctx.pathParam("id"));
        libraryService.removeBook(bookId);
        ctx.status(204);
    }

    public void registerUser(Context ctx) {
        User user = ctx.bodyAsClass(User.class);
        libraryService.registerUser(user);
        ctx.status(201);
    }

    public void borrowBook(Context ctx) {
        String userName = ctx.formParam("userName");
        String bookTitle = ctx.formParam("bookTitle");
        String result = libraryService.borrowBook(userName, bookTitle);
        ctx.result(result);
    }

    public void returnBook(Context ctx) {
        String userName = ctx.formParam("userName");
        String bookTitle = ctx.formParam("bookTitle");
        String result = libraryService.returnBook(userName, bookTitle);
        ctx.result(result);
    }

    public void generateReport(Context ctx) {
        ctx.result(libraryService.generateReport());
    }
}