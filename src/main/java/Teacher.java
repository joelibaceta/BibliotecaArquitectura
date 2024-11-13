package main.java;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    public Teacher(String name) {
        super(name, new TeacherBorrowPolicy());
    }
}