
import core.Book;
import core.BorrowPolicy;
import core.User;

public class TeacherBorrowPolicy implements BorrowPolicy {
    @Override
    public boolean canBorrow(User user, Book book) {
        return "Teacher".equals(user.getType()) && user.getBorrowedBooks().size() < 5;
    }
}

