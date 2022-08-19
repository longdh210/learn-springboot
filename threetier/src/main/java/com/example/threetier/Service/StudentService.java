package com.example.threetier.Service;

import java.util.List;

public interface StudentService<S> {
    List<S> getAllStudentsSortedByAge();
    S getStudentById(int id);
}
