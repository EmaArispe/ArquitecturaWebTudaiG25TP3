package com.tudai.integrador3.repository;

import com.tudai.integrador3.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Integer> {
}
