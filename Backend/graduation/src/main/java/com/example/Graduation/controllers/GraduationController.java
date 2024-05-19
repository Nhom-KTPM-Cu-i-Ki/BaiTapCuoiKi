package com.example.Graduation.controllers;

import com.example.Graduation.models.Graduation;
import com.example.Graduation.services.GraduationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/graduations")
@RequiredArgsConstructor
public class GraduationController {
    private final GraduationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Graduation graduation){
        service.saveGraduation(graduation);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Graduation>> findAllGraduation(){
        return  ResponseEntity.ok(service.findAllGraduations());
    }
}
