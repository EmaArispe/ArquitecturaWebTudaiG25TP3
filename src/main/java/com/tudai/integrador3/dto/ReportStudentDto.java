package com.tudai.integrador3.dto;

import lombok.Getter;

public class ReportStudentDto {
    @Getter
    private String careerName;  // Nombre de la carrera
    @Getter
    private int year;           // Anio de inscripción o egreso
    @Getter
    private long enrolled;      // Cantidad de estudiantes inscritos
    @Getter
    private long graduated;     // Cantidad de estudiantes graduados
    @Getter
    private String name;
    @Getter
    private String lastName;
    @Getter
    private int dni;

    public ReportStudentDto(String careerName, int year, long enrolled, long graduated, String name, String lastName, int dni) {
        this.careerName = careerName;
        this.year = year;
        this.enrolled = enrolled;
        this.graduated = graduated;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

}
