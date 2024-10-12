package com.tudai.integrador3.dto;

import lombok.Getter;

import java.time.LocalDate;

public class CoursesDto {
    @Getter
    private int studentId;
    @Getter
    private int careerId;
    @Getter
    private LocalDate startDate;
    @Getter
    private LocalDate finishDate;
    @Getter
    private boolean graduated;

    public CoursesDto(int studentId, int careerId, LocalDate startDate, LocalDate finishDate, boolean graduated) {
        this.studentId = studentId;
        this.careerId = careerId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.graduated = graduated;
    }
}
