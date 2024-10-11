package com.tudai.integrador3.dto;

public class StudentDto {

    private int dni;
    private int id_libreta;
    private String name;
    private String lastName;
    private int years;
    private char gender;
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

    public int getDni() {
        return dni;
    }

    public int getId_libreta() {
        return id_libreta;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYears() {
        return years;
    }

    public char getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }
}
