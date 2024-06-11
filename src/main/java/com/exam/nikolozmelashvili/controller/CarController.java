package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.request.CarRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.response.CarResponseDTO;
import com.exam.nikolozmelashvili.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addCar(@RequestBody CarRequestDTO car) {
        carService.saveCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CarResponseDTO> getCarById (@PathVariable Long id){
        CarResponseDTO carDTO = carService.getCarById(id);
        return new ResponseEntity<>(carDTO, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CarResponseDTO>> getAllCars() {
        List<CarResponseDTO> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable Long id, @RequestBody CarRequestDTO carDTO){
        carService.updateCar(id, carDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateCar(@PathVariable Long id) {
        carService.deactivateCar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<Void> deleteCarSoft(@PathVariable Long id) {
        carService.deleteCarSoft(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-hard/{id}")
    public ResponseEntity<Void> deleteCarHard(@PathVariable Long id) {
        carService.deleteCarHard(id);
        return ResponseEntity.noContent().build();
    }
}
