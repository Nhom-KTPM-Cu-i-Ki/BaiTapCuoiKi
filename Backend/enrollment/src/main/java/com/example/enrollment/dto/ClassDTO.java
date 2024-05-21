package com.example.enrollment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassDTO {
    private long classId;
    private long courseId;
    private String semester;
    private int maxStudents;
    private String instructor;
    private String status;
    private long roomId;
    private long scheduleId;
    private int enrollmentCount;

}
