package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.response.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarUpdateDTO;
import com.exam.nikolozmelashvili.services.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Cars", description = "Operations related to Cars")
@RestController
@RequestMapping("/rest/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Operation(summary = "Add a car (you can set Services and Provided Services ti null)")
    @PostMapping("/add")
    public ResponseEntity<Void> addCar(@RequestBody CarUpdateDTO car) {
        carService.saveCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get car by ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<CarDTO> getCarById (@PathVariable Long id){
        CarDTO carDTO = carService.getCarById(id);
        return new ResponseEntity<>(carDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get all cars")
    @GetMapping("/get")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @Operation(summary = "Update a car")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable Long id, @RequestBody CarUpdateDTO carDTO){
        carService.updateCar(id, carDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Change car state. (1 is active, 2 is inactive, 3 is deleted)")
    @PatchMapping("/state/{carId}/{state}")
    public ResponseEntity<Void> changeCarState(@PathVariable Long carId, @PathVariable Integer state){
        carService.changeCarState(state, carId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Deactivate a car")
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateCar(@PathVariable Long id) {
        carService.deactivateCar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Soft delete a car (car stays in the db its just unusable)")
    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<Void> deleteCarSoft(@PathVariable Long id) {
        carService.deleteCarSoft(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Hard delete a car (car gets fully deleted from db)")
    @DeleteMapping("/delete-hard/{id}")
    public ResponseEntity<Void> deleteCarHard(@PathVariable Long id) {
        carService.deleteCarHard(id);
        return ResponseEntity.noContent().build();
    }
}
