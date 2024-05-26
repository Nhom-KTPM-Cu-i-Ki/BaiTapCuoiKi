package com.example.course.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long departmentId;
    @Column(name = "department_name",nullable = false,unique = true)
    private String departmentName;
    @Column(name = "require_Credits",nullable = false)
    private int requireCredits;

    @OneToMany(mappedBy = "department")
    private List<Course> courses;
}
