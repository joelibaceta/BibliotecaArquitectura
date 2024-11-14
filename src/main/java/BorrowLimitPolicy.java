package main.java;

public class BorrowLimitPolicy implements PolicysBorrow {
    @Override
    public boolean canBorrow(User usuario) {
        return usuario.getLoanAccount().getNumberOfBorrowedBooks() < usuario.getBorrowLimit();
    }
}
