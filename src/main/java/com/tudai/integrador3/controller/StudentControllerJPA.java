package com.tudai.integrador3.controller;
import com.tudai.integrador3.dto.StudentDto;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentControllerJPA {

    @Autowired
    private StudentService studentService;

    // a) dar de alta a un estudiante
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        try{
            StudentDto createdStudent = studentService.createStudent(student);
            return ResponseEntity.ok(createdStudent);
        } catch(Exception e) {
            String errorJson = "{\"message\": \"Error al crear el estudiante\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }

    }

    //Lista todos los estudiantes
    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
        } catch (Exception e) {
            String errorJson = "{\"message\": \"Error al buscar todos los estudiantes\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    // Muestra un estudiante por DNI
    @GetMapping("/{dni}")
    public ResponseEntity<?> getStudentByDNI(@PathVariable int dni){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByDNI(dni));
        } catch (Exception e) {
            String errorJson = "{\"message\": \"Error al solicitar el estudiante\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }


    // ejemplo: /years/ASC
    // c) ordena estudiantes por algun criterio asc o desc.
    @GetMapping("/{order}/{direction}")
    public ResponseEntity<?> getStudentByOrderBy(@PathVariable String order, @PathVariable String direction){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(studentService.getStudentByOrderBy(order,direction));
        } catch (Exception e) {
            String errorJson = "{\"message\": \"Error al buscar los estudiantes ordenados por algun criterio\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }

    }


    // d)recuperar estudiante por num de libreta
    @GetMapping("/libreta/{idLibreta}")
    public ResponseEntity<?> getStudentByLibreta(@PathVariable int idLibreta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByLibreta(idLibreta));
        }
        catch(Exception e) {
        String errorJson = "{\"message\": \"Error al buscar estudiante por libreta\", \"details\"}";
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorJson);
        }
    }

    // e)recuperar todos los estudiantes filtrados por genero
    @GetMapping("/gender/{gender}")
    public ResponseEntity<?> getStudentsByGender(@PathVariable char gender) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsByGender(gender));
        } catch (Exception e) {
            String errorJson = "{\"message\": \"Error al buscar estudiante por genero\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    // g)recuperar estudiantes por carrera y ciudad
    @GetMapping("/career/{careerId}/city/{cityId}")
    public ResponseEntity<?> getStudentsByCareerAndCity(@PathVariable int careerId, @PathVariable int cityId) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsByCareerAndCity(careerId, cityId));
        } catch (Exception e) {
            String errorJson = "{\"message\": \"Error al buscar estudiantes que cursan una carrera en una determinada ciudad\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }
}
