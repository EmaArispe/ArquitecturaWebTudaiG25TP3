package com.tudai.integrador3.controller;
import com.tudai.integrador3.entity.City;
import com.tudai.integrador3.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cities")
public class CityControllerJPA {

    @Autowired
    private CityService cityService;


    // Obtener ciudad por id
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getCity(@PathVariable(value = "id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cityService.getCity(id.intValue()));
        } catch (Exception e){
                String errorJson = "{\"message\": \"Error al buscar una ciudad determinada\", \"details\"}";
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(errorJson);
        }
    }

    // Agregar ciudad
    @PostMapping()
    public @ResponseBody ResponseEntity<?> addCity(@RequestBody City newCity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createCity(newCity));
        }catch (Exception e){
            String errorJson = "{\"message\": \"Error al crear una Ciudad\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }

    // Obtener listado de ciudades
    @GetMapping
    public @ResponseBody ResponseEntity<?> getAllCities() {
        try {
         return
                 ResponseEntity.status(HttpStatus.OK).body(cityService.getAll());
        } catch (Exception e) {
            String errorJson = "{\"message\": \"Error al listar las ciudades\", \"details\"}";
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(errorJson);
        }
    }
}
