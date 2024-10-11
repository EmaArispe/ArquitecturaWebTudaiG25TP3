package com.tudai.integrador3.repository;

import com.tudai.integrador3.dto.CareerStudentDto;
import com.tudai.integrador3.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {

    //@Query("SELECT c.idCareer, c.name,COUNT(s) FROM Career c JOIN c.students s GROUP BY c.idCareer, c.name HAVING COUNT(s)>0 ORDER BY COUNT(s) DESC")
    //List<Career> findCarrersOrderedByStudentCount();

    @Query("SELECT new com.tudai.integrador3.dto.CareerStudentDto(c.idCareer, c.name,COUNT(s)) " +
            "FROM Career c JOIN c.students s " +
            "GROUP BY c.idCareer, c.name " +
            "HAVING COUNT(s) > 0 ")
    List<CareerStudentDto> findCarrersOrderedByStudentCount();

    List<Career> findByNameContaining(String name);
}
