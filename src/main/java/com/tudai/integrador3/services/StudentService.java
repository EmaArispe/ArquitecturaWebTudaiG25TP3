package com.tudai.integrador3.services;

import com.tudai.integrador3.Exeptions.ResourseNotFoundException;
import com.tudai.integrador3.dto.CoursesDto;
import com.tudai.integrador3.dto.StudentDto;
import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.entity.City;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.repository.CityRepository;
import com.tudai.integrador3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tudai.integrador3.repository.CareerRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("StudentService")
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CareerRepository careerRepository;

    private CityRepository cityRepository;


    // crear estudiante
    @Transactional
    public StudentDto createStudent(Student student) throws RuntimeException {
        Student s = studentRepository.save(student);
        return new StudentDto(s.getDni(), s.getIdLibreta(), s.getName(), s.getLastName(), s.getYears(), s.getGender(), s.getCity().getName());
    }



    //devolver todos los estudiantes
    @Transactional
    public List<StudentDto> getAll() {
        List<Student> studentslist = studentRepository.findAll();
        return studentslist.stream().map(student -> new StudentDto(
                student.getDni(),
                student.getIdLibreta(),
                student.getName(),
                student.getLastName(),
                student.getYears(),
                student.getGender(),
                student.getCity().getName())).collect(Collectors.toList());
    }

    public StudentDto getStudentByDNI(int dni){
        Optional<Student> student = studentRepository.findById(dni);
        if(student.isPresent()){
            return new StudentDto(student.get().getDni(),student.get().getIdLibreta(),student.get().getName(),
                                  student.get().getLastName(),student.get().getYears(),student.get().getGender(),
                                  student.get().getCity().getName());
        }
        else {throw new RuntimeException();}
    }



    //buscar estudiante por num de libreta
    public StudentDto getStudentByLibreta(int libreta) {
        Optional<Student> student = studentRepository.findByIdLibreta(libreta);
        if(student.isPresent()){
            return new StudentDto(student.get().getDni(),student.get().getIdLibreta(),student.get().getName(),
                                  student.get().getLastName(),student.get().getYears(),student.get().getGender(),
                                  student.get().getCity().getName());
        }else {
            throw new RuntimeException();
        }
    }

    // obtener estudiantes por genero
    public List<Student> getStudentsByGender(char gender) {
        if(gender == 'M' || gender == 'm' || gender == 'f' || gender == 'F'){
            return studentRepository.findByGender(gender);
        }else{
            throw new RuntimeException();
        }
    }

    // obtener estudiantes por carrera y ciudad
    public List<Student> getStudentsByCareerAndCity(int careerId, int cityId) {
            return studentRepository.findByCareerAndCity(careerId, cityId);
    }



    // obtnere todos los estudiantes, con opción de ordenar
    /*public List<Student> getAllStudents(String sortBy) {
        if (sortBy != null) {
            return studentRepository.findAll(Sort.by(sortBy));
        } else {
            return studentRepository.findAll();
        }
    }*/

    // matricular estudiante TODO
    /*/
    public Student enrollStudentInCareer(int studentId, int careerId) {

    } */

}
