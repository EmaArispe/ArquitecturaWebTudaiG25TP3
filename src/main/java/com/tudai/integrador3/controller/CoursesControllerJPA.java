package com.tudai.integrador3.controller;
import com.tudai.integrador3.dto.CoursesDto;
import com.tudai.integrador3.dto.EnrollStudentDto;
import com.tudai.integrador3.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/courses")
public class CoursesControllerJPA {

    @Autowired
    private CoursesService courseService;

    // b) matricular un estudiante en una carrera
    @PostMapping("/enroll")
    public ResponseEntity<?>enrollStudentCareer(@RequestBody EnrollStudentDto enrollStudentDto){
        try{
          return ResponseEntity.status(HttpStatus.CREATED).body(courseService.enrollStudentCareer(enrollStudentDto));
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error al asignar la carrera\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    // a)obtener todos los cursos
    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseService.getAllCourses());
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error al solicitar el listado de cursadas\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    // b) obtener un curso por su ID
    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable int courseId) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourseById(courseId));
        } catch (Exception e) {
            e.printStackTrace();
            String errorJson = "{\"message\": \"Error al solicitar una carrera por id determinado\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    // c) crear un nuevo curso
    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody CoursesDto courseDto) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(courseDto));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
