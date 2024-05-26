package com.example.enrollment.repositories;

import com.example.enrollment.models.Classzz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classzz,Long> {
}
