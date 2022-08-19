package com.example.threetier.Service.Impl;

import com.example.threetier.Model.Student;
import com.example.threetier.Repository.StudentRepository;
import com.example.threetier.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService<Student> {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudentsSortedByAge() {
        List<Student> listStudents = studentRepository.getAllStudent();
        Collections.sort(listStudents, (o1, o2) -> o2.getAge() - o1.getAge());
        return listStudents;
    }

    @Override
    public Student getStudentById(int id) {
        List<Student> listStudents = studentRepository.getAllStudent();
        Integer inputId = id;
        Student result = listStudents.stream().filter(student -> inputId.equals(Integer.valueOf(student.getId()))).findAny().orElse(null);
        return  result;
    }
}
