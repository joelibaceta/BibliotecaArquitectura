package main.java;

import java.util.List;

public interface BorrowPolicy {
    boolean canBorrow(List<Book> borrowedBooks);
}