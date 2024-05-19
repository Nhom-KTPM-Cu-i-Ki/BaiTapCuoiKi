package com.example.course.repositories;

import com.example.course.models.Course;
import com.example.course.models.Department;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findCourseByDepartment_DepartmentId(long departmentId);

    @Query("select c.prerequisites from Course c where c.courseId = ?1")
    List<Course> getPrerequisites(long courseId);
    @Query("select c.courseName from Course c where c.courseId = ?1")
    List<String> getCourseName(long courseId);


}
