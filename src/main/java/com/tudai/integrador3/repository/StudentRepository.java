package com.tudai.integrador3.repository;

import com.tudai.integrador3.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Recuperar estudiante por numero de libreta
    Optional<Student> findByIdLibreta(int idLibreta);

    // Recuperar estudiantes filtrados por género
    List<Student> findByGender(char gender);

    // Recuperar estudiantes por carrera y ciudad
    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.career.idCareer = :careerId AND s.city.id = :cityId")
    List<Student> findByCareerAndCity(@Param("careerId") int careerId, @Param("cityId") int cityId);
}