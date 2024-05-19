package com.example.academicInformation.controllers;

import com.example.academicInformation.dto.CourseDto;
import com.example.academicInformation.dto.GradeDto;
import com.example.academicInformation.models.Grade;
import com.example.academicInformation.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/academy/grades")
@CrossOrigin(origins = "http://localhost:3000")
public class GradeController {
    @Autowired
    private GradeService service;

    @GetMapping("/student_id/{sid}/course_id/{cid}")
    public Grade findGradeByStudentAndCourse(@PathVariable("sid") long studentId,@PathVariable("cid") long courseId){
        return (Grade) service.getGradesByStudentAndCourse(studentId,courseId);
    }
    @GetMapping("/student/{id}")
    public List<GradeDto> test(@PathVariable("id") long id){
        return service.callCourseService(id);
    }

    @GetMapping("/check/student_id/{sid}/course_id/{cid}")
    public Boolean checkPrerequisites(@PathVariable("sid") long studentId,@PathVariable("cid") long courseId){
        return service.checkPrerequisites(studentId,courseId);
    }
    @GetMapping("/check/course/{cid}/student/{sid}")
    public String findCourseRequire(@PathVariable("cid") long courseId,@PathVariable("sid") long studentId){
        return service.findCourseRequire(courseId,studentId);
    }

}
