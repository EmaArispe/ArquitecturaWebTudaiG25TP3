package com.tudai.integrador3.dto;

import java.time.LocalDate;

public class CoursesDto {
    private int studentId;
    private int careerId;
    private LocalDate startDate;
    private LocalDate finishDate;
    private boolean graduated;

    public CoursesDto(int studentId, int careerId, LocalDate startDate, LocalDate finishDate, boolean graduated) {
        this.studentId = studentId;
        this.careerId = careerId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.graduated = graduated;
    }

    // Getters y setters
    public int getStudentId() {
        return studentId;
    }

    public int getCareerId() {
        return careerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public boolean isGraduated() {
        return graduated;
    }
}
