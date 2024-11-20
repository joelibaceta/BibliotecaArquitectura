package core;

public interface BorrowPolicy {
    boolean canBorrow(User user, Book book);
}