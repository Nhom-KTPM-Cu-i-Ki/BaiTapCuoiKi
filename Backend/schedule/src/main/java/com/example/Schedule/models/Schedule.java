package com.example.Schedule.models;

import com.example.Schedule.enums.DayOfWeek;
import com.example.Schedule.enums.Time;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table()
@Builder
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scheduleId;
    @Column(name = "class_id",nullable = false)
    private long classId;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "day_of_week",nullable = false)
    private DayOfWeek dayOfWeek;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Time time;
    @Column(name = "group_class",nullable = false)
    private int group;
}
