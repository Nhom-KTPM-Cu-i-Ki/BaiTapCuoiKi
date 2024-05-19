package com.example.academicInformation.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class CourseDto {
    private long courseId;
    private String courseName;
    private int credits;

}
