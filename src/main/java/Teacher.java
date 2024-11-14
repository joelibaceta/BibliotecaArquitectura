package main.java;

public class Teacher extends User {
    public Teacher(String name) {
        super(name);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}
