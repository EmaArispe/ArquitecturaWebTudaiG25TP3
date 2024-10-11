package com.tudai.integrador3.services;
import com.tudai.integrador3.dto.CareerStudentDto;
import com.tudai.integrador3.dto.StudentDto;
import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("CareerService")
public class CareerService {
    @Autowired
    private CareerRepository careerRepository;

    //punto g/

    public List<CareerStudentDto>findCareersOrderedByStudentcount(){
        List<Object[]> careerList = careerRepository.findCarrersOrderedByStudentCount();
        return careerList.stream().map(career-> new CareerStudentDto(
                (Integer) career[0],
                (String)career[1],
                (Integer)career[2])).collect(Collectors.toList());
    }

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



}
