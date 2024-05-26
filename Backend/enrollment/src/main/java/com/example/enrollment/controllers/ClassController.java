package com.example.enrollment.controllers;

import com.example.enrollment.models.Classzz;
import com.example.enrollment.services.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/class")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService service;

    @PostMapping
    public ResponseEntity<?> responseEntity(@RequestBody Classzz aClass){
        try {
            service.saveClass(aClass);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("create that bai");
        }
        return ResponseEntity.ok("create thanh cong");
    }
    @GetMapping
    public  ResponseEntity<?> responseEntity(){
        try {
            List<Classzz> Lists = service.findAll();
            return ResponseEntity.ok(Lists);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Lay du lieu khong thanh cong");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> responseEntity(@PathVariable("id")  long id, @RequestBody Classzz classzz){
        try {
             service.update(id,classzz);
            return ResponseEntity.ok("update thanh cong");
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("update that bai");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> responseEntity(@PathVariable("id") long id){
        try {
            service.deleteClasszz(id);
            return  ResponseEntity.ok("xoa thanh cong");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Xoa khong thanh cong");
        }
    }

}
