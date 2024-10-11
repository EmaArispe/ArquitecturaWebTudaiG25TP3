package com.tudai.integrador3.entity;

import jakarta.annotation.Nullable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import jakarta.persistence.*;

@Entity
@IdClass(CoursesId.class)//necesario para que springboot reconozca la clave compuesta
public class Courses implements Serializable{
    //clave compuesta
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Student", referencedColumnName = "DNI",nullable = false)
    private Student student;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Career")
    private Career career;

    @Column(name="Fecha_Inscripcion")
    private LocalDate start_date;

    @Column(name="Fecha_Graduado")
    @Nullable
    private LocalDate finish_date;

    @Column(name="Graduado")
    private boolean graduated;

    public Courses() {}

    public Courses(Student student, Career career) {
        this.student = student;
        this.career = career;
        this.start_date = LocalDate.now();
        this.finish_date = null;
        this.graduated = false;
    }

    public Courses(Student student, Career career, LocalDate start_date) {
        this.student = student;
        this.career = career;
        this.start_date = start_date;
    }

    public Courses(Student student, Career career, LocalDate start_date, LocalDate finish_date) {
        this.student = student;
        this.career = career;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.graduated = true;
    }

    public Courses(Optional<Student> s, Optional<Student> c) {
    }

    public Career getCareer() {
        return career;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getFinish_date(){
        return finish_date;
    }

    public void setGraduated() {
        this.finish_date = LocalDate.now();
        this.graduated = true;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "student=" + student +
                ", career=" + career +
                ", start_date=" + start_date +
                ", finish_date=" + finish_date +
                ", graduated=" + graduated +
                '}';
    }
}
