package library.policy;

import library.policy.StudentLoanPolicy;
import library.policy.TeacherLoanPolicy;


public interface LoanPolicy {
    boolean canBorrow(int currentBorrowedBooks);

    static LoanPolicy createPolicy(String userType) {
        return switch (userType) {
            case "Student" -> new StudentLoanPolicy();
            case "Teacher" -> new TeacherLoanPolicy();
            default -> throw new IllegalArgumentException("Invalid user type");
        };
    }
}