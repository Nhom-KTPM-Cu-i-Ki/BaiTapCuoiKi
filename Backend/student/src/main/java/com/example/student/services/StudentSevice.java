package com.example.student.services;


import com.example.student.models.Student;
import com.example.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentSevice {
    private final StudentRepository repository;


    public void saveStudent(Student student){
        repository.save(student);
    }
    public List<Student> findAllStudent(){
        return repository.findAll();
    }

    public List<Student> findAllStudentBySchool(Integer schoolId) {
        return  repository.findAllBySchoolId(schoolId);
    }
}
