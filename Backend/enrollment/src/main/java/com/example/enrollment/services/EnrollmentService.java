package com.example.enrollment.services;

import com.example.enrollment.dto.EnrollmentDTO;
import com.example.enrollment.models.Classzz;
import com.example.enrollment.models.Enrollment;
import com.example.enrollment.repositories.EnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private  final EnrollmentRepository repository;
    private final ClassService classService;

    public  void saveEnrollment(EnrollmentDTO enrollmentDTO){
        Classzz classzz = classService.findById(enrollmentDTO.getClassId()).orElseThrow();
        Enrollment enrollment = Enrollment.builder()
                .enrollmentId(enrollmentDTO.getEnrollmentId())
                .studentId(enrollmentDTO.getStudentId())
                .classId(classzz)
                .registrationDate(enrollmentDTO.getRegistrationDate())
                .status(enrollmentDTO.getStatus())
                .confirmedDate(enrollmentDTO.getConfirmedDate())
                .creditEarned(enrollmentDTO.getCreditEarned())
                .tuitionFee(enrollmentDTO.getTuitionFee())
                .notes(enrollmentDTO.getNotes())
                        .build();
        repository.save(enrollment);
    }
    public List<Enrollment> findALlEnrollment(){
        return repository.findAll();
    }
    public Optional<Enrollment> findById(long id){
        return repository.findById(id);
    }

public Enrollment updateEnrollment(long id, EnrollmentDTO updateDTO) {
    Enrollment enrollment = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Enrollment not found"));

    if (updateDTO.getRegistrationDate() != null) {
        enrollment.setRegistrationDate(updateDTO.getRegistrationDate());
    }
    if (updateDTO.getConfirmedDate() != null) {
        enrollment.setConfirmedDate(updateDTO.getConfirmedDate());
    }
    if (updateDTO.getStatus() != null) {
        enrollment.setStatus(updateDTO.getStatus());
    }
    if (updateDTO.getCreditEarned() != null) {
        enrollment.setCreditEarned(updateDTO.getCreditEarned());
    }
    if (updateDTO.getTuitionFee() != null) {
        enrollment.setTuitionFee(updateDTO.getTuitionFee());
    }
    if (updateDTO.getNotes() != null) {
        enrollment.setNotes(updateDTO.getNotes());
    }
    if (updateDTO.getClassId() != null) {
        Classzz classzz = classService.findById(updateDTO.getClassId())
                .orElseThrow(() -> new EntityNotFoundException("Class not found"));
        enrollment.setClassId(classzz);
    }

    return repository.save(enrollment);
}

    public void deleteErm(long id){
        repository.deleteById(id);
    }
}
