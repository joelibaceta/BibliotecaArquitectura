package main.java;

import java.util.List;

public class StudentBorrowPolicy implements BorrowPolicy {
    private static final int MAX_BOOKS = 3;

    @Override
    public boolean canBorrow(List<Book> borrowedBooks) {
        return borrowedBooks.size() < MAX_BOOKS;
    }
}
