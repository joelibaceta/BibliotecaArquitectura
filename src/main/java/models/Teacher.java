package main.java.models;

public class Teacher extends User {
    public Teacher(String name) {
        super(name);
    }

    public boolean canBorrow() {
        return this.getBorrowedBooks().size() < 5;
    }
}
