package com.example.academicInformation.models;


import com.example.academicInformation.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "user_id",nullable = false)
    private long userId;
    @Column(nullable = false,columnDefinition = "NVARCHAR(255)")
    private String name;
    @Column(name = "department_id",nullable = false)
    private long departmentId;
    @Column(name = "total_credits",nullable = false)
    private int totalCredits;
    @Column(name = "graduation_status",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Status graduationStatus;
//    @OneToMany(mappedBy = "student")
//    private List<Grade> grades;
}
