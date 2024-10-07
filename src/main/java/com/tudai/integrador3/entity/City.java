package com.tudai.integrador3.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @Column (name = "idCity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "cityName")
    private String name;

    public City() {
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
