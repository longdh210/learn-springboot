package com.example.threetier.Repository;

import com.example.threetier.Model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository {
    List<Student> listStudents = new ArrayList<Student>();

    @PostConstruct
    public void createData() {
        listStudents.add(new Student(1, "Duong", 21, "Coding"));
        listStudents.add(new Student(2, "Hoang", 22, "Football"));
        listStudents.add(new Student(3, "Long", 23, "Sleep"));
        listStudents.add(new Student(4, "Maria", 24, "Swimming"));
        listStudents.add(new Student(5, "Asa", 25, "Girl"));
    }

    public List<Student> getAllStudent() {
        return listStudents;
    }

}
