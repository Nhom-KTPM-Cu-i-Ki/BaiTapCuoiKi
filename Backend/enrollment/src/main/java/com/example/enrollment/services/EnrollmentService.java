package com.example.enrollment.services;

import com.example.enrollment.dto.EnrollmentDTO;
import com.example.enrollment.enums.ClasszzType;
import com.example.enrollment.enums.Status;
import com.example.enrollment.models.Classzz;
import com.example.enrollment.models.Enrollment;
import com.example.enrollment.repositories.EnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private  final EnrollmentRepository repository;
    private final ClassService classService;

    public  void saveEnrollment(EnrollmentDTO enrollmentDTO) throws Exception {
        Classzz classzz = classService.findById(enrollmentDTO.getClassId()).orElseThrow();
        List<Enrollment> enrollments = repository.findByClassId_ClassId(enrollmentDTO.getClassId());
        if(classzz.getStatus() != ClasszzType.OPEN_FOR_REGISTRATION){
            throw  new Exception("Không thể đăng ký");
        }else if(enrollments.size()+1 > classzz.getMaxStudents()){
                throw new Exception("Lớp đã đủ");
        } else if (!canEnroll(enrollmentDTO.getStudentId(),classzz.getSemester(), enrollmentDTO.getCreditEarned())) {
                throw  new IllegalStateException("Sinh viên đã vượt quá số tín chỉ tối đa cho học kỳ này.");
        } else if (repository.existsByStudentIdAndClassId_ClassId(enrollmentDTO.getStudentId(), enrollmentDTO.getClassId())) {
            throw new IllegalStateException("Sinh viên đã đăng ký lớp học này");
        } else{
                Enrollment enrollment = Enrollment.builder()
                        .studentId(enrollmentDTO.getStudentId())
                        .classId(classzz)
                        .registrationDate(enrollmentDTO.getRegistrationDate()!= null ? enrollmentDTO.getRegistrationDate() : LocalDate.now())
                        .status(Status.PENDING)
                        .confirmedDate(enrollmentDTO.getConfirmedDate() != null ? enrollmentDTO.getConfirmedDate() : LocalDate.now())
                        .creditEarned(enrollmentDTO.getCreditEarned()!=0?enrollmentDTO.getCreditEarned():0)
                        .tuitionFee(enrollmentDTO.getTuitionFee()!=0.1?enrollmentDTO.getTuitionFee():0.1)
                        .notes(enrollmentDTO.getNotes())
                        .build();
                repository.save(enrollment);
            }

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
    if (updateDTO.getCreditEarned() != 0) {
        enrollment.setCreditEarned(updateDTO.getCreditEarned());
    }
    if (updateDTO.getTuitionFee() != 0.1) {
        enrollment.setTuitionFee(updateDTO.getTuitionFee());
    }
    if (updateDTO.getNotes() != null) {
        enrollment.setNotes(updateDTO.getNotes());
    }
    if (updateDTO.getClassId() != 0) {
        Classzz classzz = classService.findById(updateDTO.getClassId())
                .orElseThrow(() -> new EntityNotFoundException("Class not found"));
        enrollment.setClassId(classzz);
    }

    return repository.save(enrollment);
}

    public void deleteErm(long id){
        repository.deleteById(id);
    }

    public List<Enrollment> findAllEnrollmentByClassId_ClassId(long classId){
        return repository.findByClassId_ClassId(classId);
    }

    public void deleteALlEnrollmentsByClassId(long id){
        List<Enrollment> enrollments = repository.findByClassId_ClassId(id);
        repository.deleteAll(enrollments);
    }
    public void deleteEnrollment(long studentId, long classId) {
        if (!repository.existsByStudentIdAndClassId_ClassId(studentId, classId)) {
            throw new EntityNotFoundException("Sinh viên chưa đăng ký lớp học này");
        }
        Enrollment  enrollment = repository.findByStudentIdAndClassId_ClassId(studentId,classId).orElse(null);
        repository.delete(enrollment);
    }

    public int calculateTotalCreditsForSemester(long studentId, String semester) {
        List<Enrollment> enrollments = repository.findByStudentIdAndClassId_Semester(studentId, semester);
        int totalCredits = 0;
        for (Enrollment enrollment : enrollments) {
            totalCredits += enrollment.getCreditEarned();
        }
        return totalCredits;
    }
    public boolean canEnroll(long studentId, String semester, int creditsToAdd) {
        int totalCredits = calculateTotalCreditsForSemester(studentId, semester);
        return totalCredits + creditsToAdd <= 30;
    }
}
