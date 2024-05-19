package com.example.Schedule.repositories;

import com.example.Schedule.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> getSchedulesByClassId(long id);
}
