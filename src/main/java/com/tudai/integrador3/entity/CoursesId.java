package com.tudai.integrador3.entity;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class CoursesId implements Serializable {
    // Getters y setters
    private int student;
    private int career;

    public CoursesId() {}

    public CoursesId(int student, int career) {
        this.student = student;
        this.career = career;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    // equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesId that = (CoursesId) o;
        return Objects.equals(student, that.student) && Objects.equals(career, that.career);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, career);
    }
}

