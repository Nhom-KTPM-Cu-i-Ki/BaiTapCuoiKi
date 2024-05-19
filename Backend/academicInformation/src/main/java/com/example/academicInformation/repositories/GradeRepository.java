package com.example.academicInformation.repositories;

import com.example.academicInformation.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade,Long> {
    List<Grade> findByStudent_StudentId(long studentId);

    @Query("select g from Grade g where g.student.studentId = ?1 and g.courseId = ?2")
    List<Grade> findByStudent_StudentIdAndCourseId(long studentId, long courseId);

    @Query("select g.total from Grade g where g.student.studentId = ?1 and g.courseId = ?2")
    Optional<Double> findGrade(long studentId, long courseId);

    @Query("select g.courseId from Grade g where g.courseId = ?1 and g.student.studentId= ?2")
    String findCourseByCourse(long courseId,long studentId);
}
