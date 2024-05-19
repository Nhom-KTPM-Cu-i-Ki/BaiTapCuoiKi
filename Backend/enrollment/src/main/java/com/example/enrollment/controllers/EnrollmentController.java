package com.example.enrollment.controllers;

import com.example.enrollment.dto.EnrollmentDTO;
import com.example.enrollment.models.Enrollment;
import com.example.enrollment.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService service;


    @PostMapping
    public  ResponseEntity<?> responseEntity(@RequestBody EnrollmentDTO enrollmentDTO){
        try {
            service.saveEnrollment(enrollmentDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("create thanh cong");
    }
    @GetMapping
    public ResponseEntity<?> responseEntity(){
        try {
            List<Enrollment>Enrollment =service.findALlEnrollment();
            return ResponseEntity.ok( Enrollment);
        }catch (Exception e){
            return ResponseEntity.ok().body("lay du lieu khong thanh cong");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id){
        try {
            Enrollment enrollment = service.findById(id).orElseThrow(null);
            return  ResponseEntity.ok(enrollment);
        }catch (Exception e){
            return ResponseEntity.ok().body("lay du lieu khong thanh cong");
        }
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> responseEntity(@PathVariable("id") long id, @RequestBody EnrollmentDTO enrollmentDTO){
        try {
             Enrollment enrollment=service.updateEnrollment(id,enrollmentDTO);
            return ResponseEntity.ok("update thanh cong");
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("update khong thanh cong");
        }
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> responseEntity(@PathVariable("id") long id){
        try {
            service.deleteErm(id);
            return  ResponseEntity.ok("xoa thanh cong");
        }catch (Exception e){
            return ResponseEntity.ok("xoa khong thanh cong");
        }
    }
}
