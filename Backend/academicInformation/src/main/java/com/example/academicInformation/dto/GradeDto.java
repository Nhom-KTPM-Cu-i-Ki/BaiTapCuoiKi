package com.example.academicInformation.dto;

import com.example.academicInformation.models.Student;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
    private long gradeId;
    private Student student;
    private CourseDto courseDto;
    private double regular;
    private double mid;
    private double finalOfTerm;
    private double total;
}
