package com.example.enrollment.services;

import com.example.enrollment.dto.ClassDTO;
import com.example.enrollment.models.Classzz;
import com.example.enrollment.models.Enrollment;
import com.example.enrollment.repositories.ClassRepository;
import com.example.enrollment.repositories.EnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassService {
    private  final ClassRepository repository;
    private  final EnrollmentRepository enrollmentRepository;

    public void saveClass(Classzz classs){
        repository.save(classs);
    }

    public Optional<Classzz> findById(long id){
        return  repository.findById(id);
    }
    public List<ClassDTO> findAll() {
        return repository.findAllClassesWithNativeQuery();
    }

    public  void deleteClasszz(long id){
        repository.deleteById(id);
    }
    public Classzz  update(long id,Classzz classzz){
        Classzz classzz1 = repository.findById(id).orElse(null);
        if(classzz1 != null){
            classzz1.setSemester(classzz.getSemester());
            classzz1.setMaxStudents(classzz.getMaxStudents());
            classzz1.setStatus(classzz.getStatus());
            classzz1.setInstructor(classzz.getInstructor());
            return repository.save(classzz1);
        }else {
            throw new EntityNotFoundException("id not found");
        }
    }

}
