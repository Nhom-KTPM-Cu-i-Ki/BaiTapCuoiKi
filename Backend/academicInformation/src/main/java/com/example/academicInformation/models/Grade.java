package com.example.academicInformation.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private long gradeId;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;
    @Column(name = "course_id",nullable = false)
    private long courseId;
    @Column(name = "grade",nullable = false)
    private double grade;
}
