package com.tudai.integrador3.dto;

import java.time.LocalDate;

public class EnrollStudentDto {

    private int studentId;
    private int careerId;

    public EnrollStudentDto(int studentId, int careerId) {
        this.studentId = studentId;
        this.careerId = careerId;
    }

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
