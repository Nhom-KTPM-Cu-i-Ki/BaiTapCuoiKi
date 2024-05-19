package com.example.school.sevices;


import com.example.school.repositories.SchoolRepository;
import com.example.school.client.StudentClient;
import com.example.school.models.School;
import com.example.school.response.FullSchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolSevice {
    private final SchoolRepository repository;
    private final StudentClient client;
    public void saveSchool(School school){
        repository.save(school);
    }
    public List<School> findAllSchools(){
        return repository.findAll();
    }


    public FullSchoolResponse findAllSchoolsWithStudent(Integer schoolId) {
        var school =repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
