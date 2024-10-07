package com.tudai.integrador3.controller;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesControllerJPA {

    @Autowired
    private CoursesService courseService;

    // a)obtener todos los cursos
    @GetMapping
    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }

    // b) obtener un curso por su ID
    @GetMapping("/{courseId}")
    public ResponseEntity<Courses> getCourseById(@PathVariable int courseId) {
        Courses course = courseService.getCourseById(courseId);
        return ResponseEntity.ok(course);
    }

    // c)crear un nuevo curso
    @PostMapping
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course) {
        Courses createdCourse = courseService.createCourse(course);
        return ResponseEntity.ok(createdCourse);
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
