package com.example.school.controllers;

import com.example.school.sevices.SchoolSevice;
import com.example.school.models.School;
import com.example.school.response.FullSchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolSevice sevice;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        sevice.saveSchool(school);
    }
    @GetMapping
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(sevice.findAllSchools());
    }

    @GetMapping("with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(
            @PathVariable("school-id") Integer schoolId
    ){
        return ResponseEntity.ok(sevice.findAllSchoolsWithStudent(schoolId));
    }
}
