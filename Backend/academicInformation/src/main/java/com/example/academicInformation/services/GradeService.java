package com.example.academicInformation.services;

import com.example.academicInformation.dto.CourseDto;
import com.example.academicInformation.dto.GradeDto;
import com.example.academicInformation.models.Grade;
import com.example.academicInformation.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public GradeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void saveGrade(Grade grade){
        repository.save(grade);
    }

    public List<Grade> getGradesByStudent(long id){
        return repository.findByStudent_StudentId(id);
    }
    public List<Grade> getGradesByStudentAndCourse(long studentId,long courseId){
        return repository.findByStudent_StudentIdAndCourseId(studentId,courseId);
    }
    public List<GradeDto> callCourseService(long id) {
        List<Grade> grades = repository.findByStudent_StudentId(id);
        List<GradeDto> result = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<CourseDto>> entity = new HttpEntity<>(headers);
        ResponseEntity<List<CourseDto>> response = restTemplate.exchange(
                "http://localhost:8222/api/v1/courses/all",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<CourseDto>>() {} // Correct type for list
        );
        List<CourseDto> allCourses = response.getBody(); // Get list of courses
        for(CourseDto c : allCourses){
            for (Grade g : grades){
                if(c.getCourseId()==g.getCourseId()){
                    result.add(new GradeDto(g.getGradeId(),g.getStudent(),c,g.getRegular(),g.getMid(),g.getFinalOfTerm(),g.getTotal()));
                }
            }
        }

        System.out.println(allCourses);
        return result;
    }
    public String findCourseRequire(long courseId,long studentId){
        return repository.findCourseByCourse(courseId,studentId);
    }
    public boolean checkPrerequisites(long studentId, long courseId){
        Optional<Double> grade = repository.findGrade(studentId,courseId);
        if (grade.isPresent()) {
            return grade.get() >= 3;
        }
        else return false;
    }
}
