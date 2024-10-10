package com.tudai.integrador3.controller;
import com.tudai.integrador3.dto.CoursesDto;
import com.tudai.integrador3.dto.CreateCourseDto;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CoursesControllerJPA {

    @Autowired
    private CoursesService courseService;

    // a)obtener todos los cursos
    @GetMapping
    public ResponseEntity<List<CoursesDto>> getAllCourses() {
        List<CoursesDto>listCourses = courseService.getAllCourses();
        return ResponseEntity.ok(listCourses);
    }

    // b) obtener un curso por su ID
    @GetMapping("/{courseId}")
    public ResponseEntity<Courses> getCourseById(@PathVariable int courseId) {
        Courses course = courseService.getCourseById(courseId);
        return ResponseEntity.ok(course);
    }

    // c)crear un nuevo curso
    @PostMapping
    public ResponseEntity<CoursesDto> createCourse(@RequestBody CoursesDto courseDto) {
        try{
            CoursesDto course = courseService.createCourse(courseDto);
            return ResponseEntity.ok(course);
        }catch(RuntimeException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // d) actualizar un curso TODO
    /*
    @PutMapping("/{courseId}")
    public ResponseEntity<Courses> updateCourse(@PathVariable int courseId, @RequestBody Courses courseDetails) {
        Courses updatedCourse = courseService.updateCourse(courseId, courseDetails);
        return ResponseEntity.ok(updatedCourse);
    } */

    // e) eliminar un curso por su ID
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}
