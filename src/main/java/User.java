package main.java;

public abstract class User {
    private final String name;
    private final LoanAccount loanAccount;

    public User(String name) {
        this.name = name;
        this.loanAccount = new LoanAccount();
    }

    public String getName() {
        return name;
    }

    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public abstract int getBorrowLimit();
}
