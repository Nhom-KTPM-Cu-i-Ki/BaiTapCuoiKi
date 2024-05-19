package com.example.student.controllers;

import com.example.student.services.StudentSevice;
import com.example.student.models.Student;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentSevice sevice;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student){
        sevice.saveStudent(student);
    }
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudent(){
        return ResponseEntity.ok(sevice.findAllStudent());
    }

    @GetMapping("school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudent(
           @PathVariable("school-id") Integer schoolId
    ){
        return ResponseEntity.ok(sevice.findAllStudentBySchool(schoolId));
    }
}
