package com.tudai.integrador3.dto;

import lombok.Getter;

public class StudentDto {
    @Getter
    private int dni;
    @Getter
    private int id_libreta;
    @Getter
    private String name;
    @Getter
    private String lastName;
    @Getter
    private int years;
    @Getter
    private char gender;
    @Getter
    private String city;

    public StudentDto(int dni, int id_libreta, String name, String lastName, int years, char gender, String city) {
        this.dni = dni;
        this.id_libreta = id_libreta;
        this.name = name;
        this.lastName = lastName;
        this.years = years;
        this.gender = gender;
        this.city = city;
    }
}
