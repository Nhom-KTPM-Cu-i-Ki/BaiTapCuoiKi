package com.example.enrollment.repositories;

import com.example.enrollment.dto.ClassDTO;
import com.example.enrollment.models.Classzz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Classzz,Long> {
    @Query(name = "Classzz.findAllClassesWithEnrollmentCount", nativeQuery = true)
    List<ClassDTO> findAllClassesWithNativeQuery();
}
