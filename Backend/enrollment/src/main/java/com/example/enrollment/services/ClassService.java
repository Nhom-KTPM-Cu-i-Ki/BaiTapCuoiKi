package com.example.enrollment.services;

import com.example.enrollment.dto.ClassDTO;
import com.example.enrollment.dto.CourseDTO;
import com.example.enrollment.models.Classzz;
import com.example.enrollment.models.Enrollment;
import com.example.enrollment.repositories.ClassRepository;
import com.example.enrollment.repositories.EnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassService {
    private  final ClassRepository repository;
    private  final EnrollmentRepository enrollmentRepository;
    private final RestTemplate restTemplate;

    public void saveClass(Classzz classs){
        repository.save(classs);
    }
    public List<Classzz> findByCourse(long id){
        return repository.findByCourseId(id);
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

//    public List<CourseDTO> callCourseService(long id) {
//        List<Classzz> classzzes = repository.findByStudentId(id);
//        List<CourseDTO> result = new ArrayList<>();
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<List<CourseDTO>> entity = new HttpEntity<>(headers);
//        ResponseEntity<List<CourseDTO>> response = restTemplate.exchange(
//                "http://localhost:8222/api/v1/courses/all",
//                HttpMethod.GET,
//                entity,
//                new ParameterizedTypeReference<List<CourseDTO>>() {} // Correct type for list
//        );
//        List<CourseDTO> allCourses = response.getBody(); // Get list of courses
//        for(CourseDTO c : allCourses){
//            for (Classzz cl : classzzes){
//                if(c.getCourseId()==cl.getCourseId()){
////                    result.add(new ClassDTO(cl.getClassId(), cl.getCourseId());
//                }
//            }
//        }
//
//        System.out.println(allCourses);
//        return result;
//    }

}
