package com.tudai.integrador3.dto;

public class CareerStudentDto {
    private int idCareer;
    private String name;
    private Long countStudents;

    public CareerStudentDto(int idCareer, String name, Long countStudents) {
        this.idCareer = idCareer;
        this.name = name;
        this.countStudents = countStudents;
    }

    public int getIdCareer() {
        return idCareer;
    }

    public String getName() {
        return name;
    }

    public Long getCountStudents() {
        return countStudents;
    }
}
