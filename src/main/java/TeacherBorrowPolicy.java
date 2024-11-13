package main.java;

import java.util.List;

public class TeacherBorrowPolicy implements BorrowPolicy {
    private static final int MAX_BOOKS = 5;

    @Override
    public boolean canBorrow(List<Book> borrowedBooks) {
        return borrowedBooks.size() < MAX_BOOKS;
    }
}
