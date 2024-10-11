package com.tudai.integrador3.repository;

import com.tudai.integrador3.dto.CareerStudentDto;
import com.tudai.integrador3.dto.ReportStudentDto;
import com.tudai.integrador3.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {

    @Query("SELECT new com.tudai.integrador3.dto.CareerStudentDto(c.idCareer, c.name,COUNT(s)) " +
            "FROM Career c JOIN c.students s " +
            "GROUP BY c.idCareer, c.name " +
            "HAVING COUNT(s) > 0 order by COUNT(s) DESC"
            )
    List<CareerStudentDto> findCarrersOrderedByStudentCount();

    @Query("SELECT new com.tudai.integrador3.dto.ReportStudentDto(c.name, YEAR(cs.start_date), COUNT(cs.student), " +
                    "SUM(CASE WHEN cs.graduated = true THEN 1 ELSE 0 END), " +
                    "s.name, s.lastName, s.dni) " +  // Seleccionamos los campos del estudiante
                    "FROM Career c JOIN c.students cs " +
                    "JOIN cs.student s " +
                    "GROUP BY c.name, YEAR(cs.start_date), s.name, s.lastName, s.dni " +
                    "ORDER BY c.name, YEAR(cs.start_date) desc")
    List<ReportStudentDto>getStudentReportCarreerDto();

    List<Career> findByNameContaining(String name);
}
