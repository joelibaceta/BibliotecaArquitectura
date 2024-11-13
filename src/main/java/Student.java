package main.java;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    public Student(String name) {
        super(name, new StudentBorrowPolicy());
    }
}