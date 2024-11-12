package library.policy;

public class TeacherLoanPolicy implements LoanPolicy {
    private static final int MAX_BOOKS = 5;

    @Override
    public boolean canBorrow(int currentBorrowedBooks) {
        return currentBorrowedBooks < MAX_BOOKS;
    }
}