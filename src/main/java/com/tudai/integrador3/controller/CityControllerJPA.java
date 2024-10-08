package com.tudai.integrador3.controller;
import com.tudai.integrador3.entity.Career;
import com.tudai.integrador3.entity.City;
import com.tudai.integrador3.entity.Student;
import com.tudai.integrador3.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityControllerJPA {

    @Qualifier("cityRepository")
    @Autowired
    private CityRepository repository;

    public CityControllerJPA(@Qualifier("cityRepository") CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getCity(@PathVariable(value = "id") Long id){
        Optional<City> oCity = repository.findById(id.intValue());
        return (!oCity.isPresent())? ResponseEntity.notFound().build() : ResponseEntity.ok(oCity);
    }

    /* Json {"name": "Tandil"} */

    @PostMapping()
    public @ResponseBody ResponseEntity<?> addCity(@RequestBody City newCity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newCity));
    }

    @GetMapping
    public List<City> getAllCities() {
        return repository.findAll();
    }
}
