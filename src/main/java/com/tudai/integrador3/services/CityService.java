package com.tudai.integrador3.services;

import com.tudai.integrador3.entity.City;
import com.tudai.integrador3.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service ("CityService")
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    //crea una ciudad
    public City createCity(City newCity){
        return cityRepository.save(newCity);
    }

    //devuelve una ciudad por id
    public Optional<City> getCity(Integer id){
        return cityRepository.findById(id);
    }

    //lista todas las ciudades
    public List<City> getAll(){
        return cityRepository.findAll();
    }
}
