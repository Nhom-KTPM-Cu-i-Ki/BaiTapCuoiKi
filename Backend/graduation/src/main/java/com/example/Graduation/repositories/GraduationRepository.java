package com.example.Graduation.repositories;

import com.example.Graduation.models.Graduation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GraduationRepository extends JpaRepository<Graduation,Long> {
}
