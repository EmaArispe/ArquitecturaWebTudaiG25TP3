package com.tudai.integrador3.dto;

import lombok.Getter;

public class CareerStudentDto {
    @Getter
    private int idCareer;
    @Getter
    private String name;
    @Getter
    private Long countStudents;

    public CareerStudentDto(int idCareer, String name, Long countStudents) {
        this.idCareer = idCareer;
        this.name = name;
        this.countStudents = countStudents;
    }
}
