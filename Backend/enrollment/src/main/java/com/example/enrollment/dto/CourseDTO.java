package com.example.enrollment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDTO {
    private long courseId;
    private String courseName;
    private int credits;
}
