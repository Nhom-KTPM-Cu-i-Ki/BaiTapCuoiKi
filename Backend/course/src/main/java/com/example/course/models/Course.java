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
    @Column(name = "course_name",nullable = false,unique = true,columnDefinition = "nvarchar(255)")
    private String courseName;
    @Column(nullable = false)
    private int credits;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prerequisites",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "prerequisite_id"))
    private Set<Course> prerequisites;

    @ManyToOne
    private Department department;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", prerequisites=" + prerequisites +
                ", department=" + department +
                '}';
    }
}
