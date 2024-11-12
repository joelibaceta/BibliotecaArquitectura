package library.policy;


public class StudentLoanPolicy implements LoanPolicy {
    private static final int MAX_BOOKS = 2;

    @Override
    public boolean canBorrow(int currentBorrowedBooks) {
        return currentBorrowedBooks < MAX_BOOKS;
    }
}