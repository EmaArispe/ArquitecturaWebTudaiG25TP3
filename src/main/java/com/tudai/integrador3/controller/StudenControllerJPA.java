package com.tudai.integrador3.controller;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudenControllerJPA {


    @Autowired
    private StudentService studentService;

    // a) dar de alta a un estudiante
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    // b)matricular a un estudiante en una carrera TODO
    /*
    @PostMapping("/{studentId}/enroll")
    public ResponseEntity<Student> enrollStudentInCareer(@PathVariable int studentId, @RequestParam int careerId) {
        Student updatedStudent = studentService.enrollStudentInCareer(studentId, careerId);
        return ResponseEntity.ok(updatedStudent);
    } */

    // c)recuperar todos los estudiantes ordenados por un criterio
    @GetMapping
    public List<Student> getAllStudents(@RequestParam(required = false) String sortBy) {
        return studentService.getAllStudents(sortBy);
    }//coment

    // d)recuperar estudiante por num de libreta
    @GetMapping("/libreta/{libreta}")
    public ResponseEntity<Student> getStudentByLibreta(@PathVariable int libreta) {
        return studentService.getStudentByLibreta(libreta);
    }

    // e)recuperar todos los estudiantes filtrados por genero
    @GetMapping("/gender/{gender}")
    public List<Student> getStudentsByGender(@PathVariable char gender) {
        return studentService.getStudentsByGender(gender);
    }

    // g)recuperar estudiantes por carrera y ciudad
    @GetMapping("/career/{careerId}/city/{city}")
    public List<Student> getStudentsByCareerAndCity(@PathVariable int careerId, @PathVariable String city) {
        return studentService.getStudentsByCareerAndCity(careerId, city);
    }
}
