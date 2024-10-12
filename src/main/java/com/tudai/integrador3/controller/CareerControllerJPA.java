package com.tudai.integrador3.controller;

import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/careers")
public class CareerControllerJPA {
    @Autowired
    private CareerService careerService;

    //crear o actualizar una carrera
    @PostMapping
    public ResponseEntity<?> createOrUpdateCareer(@RequestBody Career career) {
        try {
            return  ResponseEntity.status(HttpStatus.CREATED).body(careerService.createOrUpdateCareer(career));
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error al ingresar una carrera nueva\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    //obtener todas las carreras
    @GetMapping
    public ResponseEntity<?> getAllCareers() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(careerService.getAllCareers());
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error al obtener la lista de carreras\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    //obtener carrera por id
    @GetMapping("/{id}")
    public ResponseEntity<?> getCareerById(@PathVariable int id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(careerService.getCareerById(id));
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error al obtener la lista de carreras\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }

    }

    /*
        f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
     */
    @GetMapping("/inscripts")
    public ResponseEntity<?> findCarrersOrderedByStudentCount() {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(careerService.findCareersOrderedByStudentcount());
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error en la consulta\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    /*
        h) generar un reporte de las carreras, que para cada carrera incluya información de los
        inscriptos y egresados por año
    */
    @GetMapping("/report")
    public ResponseEntity<?> getStudentReportCarreerDto() {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(careerService.getStudentReportCarreerDto());
        } catch (
                Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error en la consulta\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }

    }
}
