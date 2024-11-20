
import core.Book;
import core.BorrowPolicy;
import core.User;

public class StudentBorrowPolicy implements BorrowPolicy {
    @Override
    public boolean canBorrow(User user, Book book) {
        return "Student".equals(user.getType()) && user.getBorrowedBooks().size() < 2;
    }
}

