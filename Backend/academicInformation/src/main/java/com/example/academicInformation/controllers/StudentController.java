package com.example.academicInformation.controllers;

import com.example.academicInformation.models.Student;
import com.example.academicInformation.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/academy/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentService service;
    @GetMapping("/student_id/{id}")
    public Student findStudent(@PathVariable("id") long id){
        Optional<Student> s = service.findStudent(id);
        return s.get();
    }
    @GetMapping("/department_id/{id}")
    public List<Student> findStudentByDepartment(@PathVariable("id")long id){
        return service.findStudentByDepartment(id);
    }
}
