package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addCar(@RequestBody CarDTO car) {
        carService.saveCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
