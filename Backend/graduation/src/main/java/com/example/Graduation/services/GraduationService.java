package com.example.Graduation.services;

import com.example.Graduation.models.Graduation;
import com.example.Graduation.repositories.GraduationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GraduationService {
    private final GraduationRepository repository;
    public void saveGraduation(Graduation graduation){
        repository.save(graduation);
    }
    public List<Graduation> findAllGraduations(){
        return repository.findAll();
    }

}
