package com.tudai.integrador3.csvFile;

//Crea JPARepositoryFactory con repositorios de cada entidad para leer CSV y persistirlos

import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.entity.City;
import com.tudai.integrador3.entity.Courses;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.repository.CareerRepository;
import com.tudai.integrador3.repository.CityRepository;
import com.tudai.integrador3.repository.CourseRepository;
import com.tudai.integrador3.repository.StudentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class CSVReader {

    private final CityRepository cityRepository;
    private final CareerRepository careerRepository;
    private final CourseRepository coursesRepository;
    private final StudentRepository studentRepository;

    private static final String PATH = "src/main/resources/";
    private static final String CSVSPLIT = ",";

    @Autowired
    public CSVReader(CityRepository cityRepository, CareerRepository careerRepository, CourseRepository coursesRepository, StudentRepository studentRepository) {
        this.cityRepository = cityRepository;
        this.careerRepository = careerRepository;
        this.coursesRepository = coursesRepository;
        this.studentRepository = studentRepository;
    }

    public void loadData(){
        readFileCity();
        readFileCareer();
        readFileStudent();
        readFileCourses();
    }

    //lee archivos y los agrega a la base
    private void readFileStudent() {
        String csvFile = PATH+"student.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    String[] datos = line.split(CSVSPLIT);
                    Optional<City> cityStudent = cityRepository.findById(Integer.parseInt(datos[6]));
                    Student newStudent = new Student(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]),
                            datos[2], datos[3], Integer.parseInt(datos[4]),
                            datos[5].charAt(0), cityStudent.orElse(null));
                    studentRepository.save(newStudent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFileCity() {
        String csvFile = PATH+"city.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    String[] datos = line.split(CSVSPLIT);
                    City newCity = new City(Integer.parseInt(datos[0]), datos[1]);
                    cityRepository.save(newCity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFileCareer() {
        String csvFile = PATH+"career.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    String[] datos = line.split(CSVSPLIT);
                    Career newCareer = new Career(Integer.parseInt(datos[0]), datos[1]);
                    careerRepository.save(newCareer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFileCourses() {
        String csvFile = PATH+"courses.csv";
        String line = "";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("/") && !line.trim().isEmpty()) {
                    String[] datos = line.split(CSVSPLIT);
                    Optional<Student> student = studentRepository.findById(Integer.parseInt(datos[0]));
                    Optional<Career> career = careerRepository.findById(Integer.parseInt(datos[1]));

                    // ---- VER QUE PASO CUANDO VIENE NULL ---

                    coursesRepository.save(getCorses(student.get(),career.get(),datos));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private @NotNull Courses getCorses(Student student, Career career, String[] datos){
        LocalDate inscrip = LocalDate.of(Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),Integer.parseInt(datos[4]));
        Courses newCourses = null;
        if(Integer.parseInt(datos[5]) == 1){
            LocalDate fechaGraduado = LocalDate.of(Integer.parseInt(datos[6]),Integer.parseInt(datos[7]),Integer.parseInt(datos[8]));
            newCourses = new Courses(student,career,inscrip,fechaGraduado);
        }else{
            newCourses = new Courses(student,career,inscrip);
        }
        return newCourses;
    }
}

