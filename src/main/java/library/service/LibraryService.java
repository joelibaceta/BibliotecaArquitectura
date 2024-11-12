package library.service;

import library.model.Book;
import library.model.User;

import library.repository.LibraryRepository;

import java.util.List;

public class LibraryService {
    private final LibraryRepository repository = new LibraryRepository();

    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    public void addBook(Book book) {
        repository.addBook(book);
    }

    public void removeBook(Long bookId) {
        repository.removeBook(bookId);
    }

    public void registerUser(User user) {
        repository.addUser(user);
    }

    public String borrowBook(String userName, String bookTitle) {
        User user = repository.getUserByName(userName);
        Book book = repository.getBookByTitle(bookTitle);

        if (user == null || book == null) {
            return "User or book not found.";
        }

        if (!user.canBorrow()) {
            return userName + " could not borrow " + bookTitle + " (limit reached).";
        }

        user.borrowBook(book);
        repository.removeBook(book.getId());
        return userName + " borrowed " + bookTitle;
    }

    public String returnBook(String userName, String bookTitle) {
        User user = repository.getUserByName(userName);
        if (user == null) return "User not found.";

        Book book = user.getBorrowedBooks().stream()
                .filter(b -> b.getTitle().equals(bookTitle))
                .findFirst()
                .orElse(null);

        if (book == null) return "Book not found in user's borrowed books.";

        user.returnBook(book);
        repository.addBook(book);
        return userName + " returned " + bookTitle;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder("Library Report\n");
        report.append("Available Books:\n");
        for (Book book : repository.getAllBooks()) {
            report.append("- ").append(book.getTitle()).append("\n");
        }

        report.append("\nBorrowed Books:\n");
        for (User user : repository.getAllUsers()) { // Iterar por todos los usuarios
            for (Book book : user.getBorrowedBooks()) {
                report.append("- ").append(book.getTitle())
                        .append(" borrowed by ").append(user.getName())
                        .append("\n");
            }
        }

        return report.toString();
    }


}