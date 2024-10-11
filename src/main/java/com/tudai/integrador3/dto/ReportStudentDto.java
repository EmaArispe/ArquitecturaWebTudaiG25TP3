package com.tudai.integrador3.dto;

import java.time.LocalDate;

public class ReportStudentDto {

    private String careerName;  // Nombre de la carrera
    private int year;           // Anio de inscripción o egreso
    private long enrolled;      // Cantidad de estudiantes inscritos
    private long graduated;     // Cantidad de estudiantes graduados
    private String name;
    private String lastName;
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

    public String getCareerName() {
        return careerName;
    }

    public int getYear() {
        return year;
    }

    public long getEnrolled() {
        return enrolled;
    }

    public long getGraduated() {
        return graduated;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDni() {
        return dni;
    }
}
