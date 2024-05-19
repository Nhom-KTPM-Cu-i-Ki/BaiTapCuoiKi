package com.example.course.controllers;

import com.example.course.models.Department;
import com.example.course.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/")
    public ResponseEntity<List<Department>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
