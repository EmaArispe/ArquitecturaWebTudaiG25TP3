package com.tudai.integrador3.entity;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Student {
    @Id
    @Column(name="DNI")
    private int dni;

    @Column(name="idLibreta")
    private int idLibreta;

    @Column(name="Nombre")
    private String name;

    @Column(name="Apellido")
    private String lastName;

    @Column(name="Edad")
    private int years;

    @Column(name="Genero")
    private char gender;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Courses> courses;  // muestro todas las carreras que cursa el estudiante

    public Student(){}

    public Student(int dni,int idLibreta, String name, String lastName, int years, char gender ,City city) {
        this.dni=dni;
        this.idLibreta=idLibreta;
        this.name = name;
        this.lastName = lastName;
        this.years = years;
        this.gender = gender;
        this.city = city;
        this.courses=new ArrayList<>();
    }

    public int getIdLibreta(){
        return idLibreta;
    }

    public int getDni(){
        return dni;
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

    public City getCity() {
        return city;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void addCourses(Courses courses){
        this.courses.add(courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "dni=" + dni +
                ", idLibreta=" + idLibreta +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", years=" + years +
                ", gender=" + gender +
                ", city=" + city +
                ", courses=" + courses +
                '}';
    }
}
