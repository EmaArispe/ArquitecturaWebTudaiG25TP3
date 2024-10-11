package com.tudai.integrador3.repository;

import com.tudai.integrador3.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query("SELECT c FROM City c WHERE c.name = :name")
    public default List<City> findAllByName(String name) {return new ArrayList<>();};
    @Query("SELECT c FROM City c WHERE c.id=:id")
    City existsById(long id);
}
