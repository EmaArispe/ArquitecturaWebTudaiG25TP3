package com.tudai.integrador3.dto;

public class CareerStudentDto {
    private int idCareer;
    private String name;
    private int countStudents;

    public CareerStudentDto(int idCareer, String name, int countStudents) {
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

    public int getCountStudents() {
        return countStudents;
    }
}
