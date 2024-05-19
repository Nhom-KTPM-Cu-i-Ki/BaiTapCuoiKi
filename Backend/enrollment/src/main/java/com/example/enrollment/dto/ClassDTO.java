package com.example.enrollment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClassDTO {
    private long classId;
    private long courseId;
    private String semester;
    private int maxStudents;
    private String instructor;
    private long roomId;
    private long scheduleId;
}
