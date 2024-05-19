package com.example.course.services;

import com.example.course.models.Department;
import com.example.course.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveDepartment(Department department) {departmentRepository.save(department);}

    public List<Department> findAll(){return departmentRepository.findAll();}

    public Optional<Department> findById(long id) {return departmentRepository.findById(id);}
}
