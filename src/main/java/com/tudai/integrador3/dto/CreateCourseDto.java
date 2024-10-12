package com.tudai.integrador3.dto;

import lombok.Getter;
import lombok.Setter;

public class CreateCourseDto {

    @Getter @Setter
    private int studentId;
    @Getter @Setter
    private int careerId;

    public CreateCourseDto() {}
}


