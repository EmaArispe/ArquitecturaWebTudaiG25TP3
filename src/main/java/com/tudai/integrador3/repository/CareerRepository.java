package com.tudai.integrador3.repository;

import com.tudai.integrador3.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Integer> {

    @Query("SELECT c FROM  Career c")
    List<Career> findCarrersOrderedByStudentCount();

    List<Career> findByNameContaining(String name);
}
