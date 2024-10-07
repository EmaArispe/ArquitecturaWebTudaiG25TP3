package com.tudai.integrador3.services;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CourseRepository courseRepository;

    //obtener todos los cursos
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    // crear un nuevo curso
    public Courses createCourse(Courses course) {
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
