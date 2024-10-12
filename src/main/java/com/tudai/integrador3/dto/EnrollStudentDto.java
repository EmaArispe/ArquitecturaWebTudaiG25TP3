package com.tudai.integrador3.dto;

import lombok.Getter;
import lombok.Setter;

public class EnrollStudentDto {

    @Getter @Setter
    private int studentId;
    @Getter @Setter
    private int careerId;

    public EnrollStudentDto(int studentId, int careerId) {
        this.studentId = studentId;
        this.careerId = careerId;
    }

}
