package com.tudai.integrador3.services;
import com.tudai.integrador3.Exeptions.ResourseNotFoundException;
import com.tudai.integrador3.dto.CoursesDto;
import com.tudai.integrador3.dto.EnrollStudentDto;
import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.repository.CareerRepository;
import com.tudai.integrador3.repository.CourseRepository;
import com.tudai.integrador3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursesService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CareerRepository careerRepository;


    public CoursesDto enrollStudentCareer(EnrollStudentDto enrollStudentDto){

            Optional<Career> c = careerRepository.findById(enrollStudentDto.getCareerId());
            Optional<Student> s = studentRepository.findById(enrollStudentDto.getStudentId());
            if(c==null||s==null) {
                throw new RuntimeException();
            }
            Courses course = courseRepository.save(new Courses(s.get(), c.get()));
            return new CoursesDto(course.getStudent().getDni(), course.getCareer().getId(), course.getStart_date(), course.getFinish_date(), course.isGraduated());
    }


    //obtener todos los cursos
    public List<CoursesDto> getAllCourses() {
        List<Courses>courses = courseRepository.findAll();
        return courses.stream().map(course->new CoursesDto(
                course.getStudent().getDni(),
                course.getCareer().getId(),
                course.getStart_date(),
                course.getFinish_date(),
                course.isGraduated())).collect(Collectors.toList());
    }

    // crear un nuevo curso
    public CoursesDto createCourse(CoursesDto courseDto) throws ResourseNotFoundException {
        if(!studentRepository.existsById(courseDto.getStudentId())){
            throw new ResourseNotFoundException("El estudiante no existe");
        }
        if(!careerRepository.existsById(courseDto.getCareerId())){
            throw new ResourseNotFoundException("La carrera no existe");
        }
        Student student = studentRepository.findById(courseDto.getStudentId()).get();
        Career career = careerRepository.findById(courseDto.getCareerId()).get();
        //si existen creo cursada
        Courses c = courseRepository.save(new Courses(student,career,courseDto.getStartDate(),courseDto.getFinishDate()));
        return new CoursesDto(c.getStudent().getIdLibreta(),c.getCareer().getId(),c.getStart_date(),c.getFinish_date(),c.isGraduated());
    }

    //obtener un curso por su ID
    public Courses getCourseById(int courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

}
