package com.example.course.controllers;

import com.example.course.models.Course;
import com.example.course.services.CourseService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping("/department_id/{id}")
    public ResponseEntity<List<Course>> getCoursesByDepartment(@PathVariable("id") long id){
        return ResponseEntity.ok(service.findByDepartment(id));
    }

    @GetMapping("/course_id/{id}")
    public Course getCourse(@PathVariable("id") long id){
        return service.findCourse(id).get();
    }

    @GetMapping("/all")
    public List<Course> allCourses(){return service.findAll();}
    @GetMapping("/name/{id}")
    public List<String> getCourseName(@PathVariable("id") long id){
        return service.getCourseName(id);
    }

    @GetMapping("/course_require/department/{did}/student/{sid}")
    public List<Course> findCourseRequire(@PathVariable("did") long did,@PathVariable("sid") long sid){return service.callGradeService(sid,did);}
}
