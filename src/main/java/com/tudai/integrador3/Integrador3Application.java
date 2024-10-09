package com.tudai.integrador3;

import com.tudai.integrador3.csvFile.CSVReader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Integrador3Application {
	public static void main(String[] args) {
		SpringApplication.run(Integrador3Application.class, args);
	}

}
