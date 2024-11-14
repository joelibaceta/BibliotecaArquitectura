package main.java.models;

public class Student extends User {
    public Student(String name) {
        super(name);
    }

    public boolean canBorrow() {
        return this.getBorrowedBooks().size() < 2;
    }

}
