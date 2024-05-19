package com.example.course.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    @Column(name = "course_name",nullable = false,unique = true)
    private String courseName;
    @Column(nullable = false)
    private int credits;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="prerequisites", joinColumns = @JoinColumn(name="course_id"))
    @Column(name="prerequisite_id", nullable = false)

    private Set<Long> prerequisite;

    @ManyToOne
    private Department department;
}
