package com.example.academicInformation.services;

import com.example.academicInformation.models.Student;
import com.example.academicInformation.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }

    public Optional<Student> findStudent(long id){
        return repository.findById(id);
    }

    public List<Student> findAllStudent(){
        return repository.findAll();
    }

    public List<Student> findStudentByDepartment(long id){
        return repository.findStudentByDepartmentId(id);
    }
}
