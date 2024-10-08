package com.tudai.integrador3.services;
import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CareerService")
public class CareerService {
    @Autowired
    private CareerRepository careerRepository;

    // crear o actualizar una carrera
    public Career createOrUpdateCareer(Career career) {
        return careerRepository.save(career);
    }

    // obtener todas las carreras
    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    // obtener carrera por id
    public Optional<Career> getCareerById(int careerId) {
        return careerRepository.findById(careerId);
    }

    // eliminar una carrera por id
    public void deleteCareer(int careerId) {
        careerRepository.deleteById(careerId);
    }

    // buscar carrera por nombre
    public List<Career> findCareersByName(String name) {
        return careerRepository.findByNameContaining(name);
    }
}
