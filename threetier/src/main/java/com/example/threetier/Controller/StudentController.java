package com.example.threetier.Controller;

import com.example.threetier.Model.Student;
import com.example.threetier.Service.Impl.StudentServiceImpl;
import com.example.threetier.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
public class StudentController {
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping("/api/v1/get")
    public String getStudents(Model model) {
        model.addAttribute("students", studentServiceImpl.getAllStudentsSortedByAge());
        return "table";
    }

    @ResponseBody
    @GetMapping("api/v1/getById")
    public Student getStudentById(@RequestParam(value="id", defaultValue = "1") int id) {
        return studentServiceImpl.getStudentById(id);
    }
}
