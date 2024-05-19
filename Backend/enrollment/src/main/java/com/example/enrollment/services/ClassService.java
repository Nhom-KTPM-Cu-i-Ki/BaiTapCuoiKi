package com.example.enrollment.services;

import com.example.enrollment.models.Classzz;
import com.example.enrollment.repositories.ClassRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassService {
    private  final ClassRepository repository;

    public void saveClass(Classzz classs){
        repository.save(classs);
    }

    public Optional<Classzz> findById(long id){
        return  repository.findById(id);
    }
    public List<Classzz> findAll(){
        return repository.findAll();
    }

    public List<Classzz> findByCourse(long id){
        return repository.getClasszzByCourseId(id);
    }

    public  void deleteClasszz(long id){
        repository.deleteById(id);
    }
    public Classzz  update(long id,Classzz classzz){
        Classzz classzz1 = repository.findById(id).orElse(null);
        if(classzz1 != null){
            classzz1.setSemester(classzz.getSemester());
            classzz1.setMaxStudents(classzz.getMaxStudents());
            classzz1.setInstructor(classzz.getInstructor());
            return repository.save(classzz1);
        }else {
            throw new EntityNotFoundException("id not found");
        }
    }
//    public Classzz findByIdEnrollment(long id){
//
//    }
}
