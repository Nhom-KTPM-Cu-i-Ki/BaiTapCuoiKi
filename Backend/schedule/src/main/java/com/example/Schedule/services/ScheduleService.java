package com.example.Schedule.services;

import com.example.Schedule.models.Schedule;
import com.example.Schedule.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getScheduleByClass(long id){
        return scheduleRepository.getSchedulesByClassId(id);
    }

    public void saveSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }
}
