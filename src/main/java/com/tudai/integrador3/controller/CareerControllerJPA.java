package com.tudai.integrador3.controller;

import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.services.CareerService;
import com.tudai.integrador3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/careers")
public class CareerControllerJPA {
    @Autowired
    private CareerService careerService;

    //crear o actualizar una carrera
    @PostMapping
    public ResponseEntity<Career> createOrUpdateCareer(@RequestBody Career career) {
        try{
            Career savedCareer = careerService.createOrUpdateCareer(career);
            return ResponseEntity.ok(savedCareer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //obtener todas las carreras
    @GetMapping
    public List<Career> getAllCareers() {
        return careerService.getAllCareers();
    }

    //obtener carrera por id
    @GetMapping("/{id}")
    public ResponseEntity<Career> getCareerById(@PathVariable int id) {
        Optional<Career> career = careerService.getCareerById(id);
        return career.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/inscripts")
    public ResponseEntity<?> findCarrersOrderedByStudentCount(){
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body((Career) careerService.findCareersOrderedByStudentcount());
        } catch (Exception e) {
            String errorJson = "{\"message\": \"Error en la consulta\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

}
