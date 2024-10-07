package com.tudai.integrador3.repository;

import com.tudai.integrador3.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Integer> {
    List<Career> findByNameContaining(String name);
}
