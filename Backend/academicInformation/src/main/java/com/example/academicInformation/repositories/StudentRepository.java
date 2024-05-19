package com.example.academicInformation.repositories;

import com.example.academicInformation.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByDepartmentId(long departmentId);

    List<Student> findStudentByDepartmentId(long departmentId);
}
