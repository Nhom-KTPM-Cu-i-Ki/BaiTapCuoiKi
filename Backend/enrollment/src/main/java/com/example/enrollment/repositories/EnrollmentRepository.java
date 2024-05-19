package com.example.enrollment.repositories;

import com.example.enrollment.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {


    List<Enrollment> findByClassId_ClassId(long classId);
    boolean existsByStudentIdAndClassId_ClassId(long studentId, long classId);
    Optional<Enrollment> findByStudentIdAndClassId_ClassId(long studentId, long classId);

    List<Enrollment> findByStudentIdAndClassId_Semester(long studentId, String semester);
}
