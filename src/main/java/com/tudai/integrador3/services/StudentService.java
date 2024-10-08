package com.tudai.integrador3.services;

import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tudai.integrador3.repository.CareerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("StudentService")
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CareerRepository careerRepository;


    // crear estudiante
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student>getAll(){
        return studentRepository.findAll();
    }

    // obtnere todos los estudiantes, con opción de ordenar
    public List<Student> getAllStudents(String sortBy) {
        if (sortBy != null) {
            return studentRepository.findAll(Sort.by(sortBy));
        } else {
            return studentRepository.findAll();
        }
    }

    // matricular estudiante TODO
    /*/
    public Student enrollStudentInCareer(int studentId, int careerId) {

    } */

    //buscar estudiante por num de libreta
    public ResponseEntity<Student> getStudentByLibreta(int libreta) {
        Optional<Student> student = studentRepository.findByIdLibreta(libreta);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // obtener estudiantes por genero
    public List<Student> getStudentsByGender(char gender) {
        return studentRepository.findByGender(gender);
    }

    // obtener estudiantes por carrera y ciudad
    public List<Student> getStudentsByCareerAndCity(int careerId, String city) {
        return studentRepository.findByCareerAndCity(careerId, city);
    }
}
