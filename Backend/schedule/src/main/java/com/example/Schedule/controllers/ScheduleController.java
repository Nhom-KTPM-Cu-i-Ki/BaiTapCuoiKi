package com.example.Schedule.controllers;

import com.example.Schedule.models.Schedule;
import com.example.Schedule.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@CrossOrigin(origins = "http://localhost:3000")
public class ScheduleController {
    @Autowired
    private ScheduleService service;

    @GetMapping("/class_id/{id}")
    public List<Schedule> getScheduleByClass(@PathVariable("id") long id){
        return service.getScheduleByClass(id);
    }
}
