package com.tudai.integrador3.services;
import com.tudai.integrador3.dto.CoursesDto;
import com.tudai.integrador3.dto.CreateCourseDto;
import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.repository.CareerRepository;
import com.tudai.integrador3.repository.CourseRepository;
import com.tudai.integrador3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CareerRepository careerRepository;

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
    public Courses createCourse(CoursesDto courseDto) {
        System.out.print(courseDto.getStudentId());
        Student student = studentRepository.findById(courseDto.getStudentId()).
                orElseThrow(() -> new RuntimeException("No existe estudiante"));
        Career career = careerRepository.findById(courseDto.getCareerId()).
                orElseThrow(() -> new RuntimeException("No existe carrera"));
        //si existen creo cursada
        Courses course = new Courses(student,career,courseDto.getStartDate(),courseDto.getFinishDate());
        return courseRepository.save(course);
    }

    //obtener un curso por su ID
    public Courses getCourseById(int courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    //eliminar un curso por su ID
    public void deleteCourse(int courseId) {
        Courses course = getCourseById(courseId);
        courseRepository.delete(course);
    }
}
