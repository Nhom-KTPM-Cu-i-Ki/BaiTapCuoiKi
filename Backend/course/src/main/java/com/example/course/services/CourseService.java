package com.example.course.services;

import com.example.course.models.Course;
import com.example.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    public CourseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void saveCourse(Course course){repository.save(course);}
    public List<Course> findAll(){return repository.findAll();}

    public List<Course> findByDepartment(long id){
        return repository.findCourseByDepartment_DepartmentId(id);
    }

    public Optional<Course> findCourse(long id){
        return repository.findById(id);
    }
    public List<String> getCourseName(long id){
        return repository.getCourseName(id);
    }

    public List<Course> getPrerequisites(long id){return (List<Course>) repository.getPrerequisites(id);}

    public List<Course> callGradeService(long sid,long did) {
        HttpHeaders headers = new HttpHeaders();
        List<Course> courses = repository.findCourseByDepartment_DepartmentId(did);
        List<Course> result =new ArrayList<>();
        for(Course c: courses) {
            HttpEntity<String> entity = new HttpEntity<>(headers);
            long id = c.getCourseId();
            ResponseEntity<String> response = restTemplate.exchange(
                    "http://localhost:8222/api/v1/academy/grades/check/course/{id}/student/{sid}",
                    HttpMethod.GET,
                    null, // Assuming no request body
                    String.class,
                    c.getCourseId(),
                    sid
            );
            if(response.getBody()==null) {
                result.add(c);
            }
        }
        return result;
    }

}
