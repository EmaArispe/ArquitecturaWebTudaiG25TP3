package com.tudai.integrador3.dto;

public class CreateCourseDto {


    private int studentId;  // o String si el DNI es un String
    private int careerId;

    public CreateCourseDto() {}

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCareerId() {
        return careerId;
    }

    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }
}


