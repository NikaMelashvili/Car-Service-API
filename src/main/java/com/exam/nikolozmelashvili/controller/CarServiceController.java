package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.services.CarServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/services")
public class CarServiceController {

    private final CarServicesService carServicesService;

    @Autowired
    public CarServiceController(CarServicesService carServicesService) {
        this.carServicesService = carServicesService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveCarService(@RequestBody CarServicesDTO carService){
        carServicesService.insertService(carService);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
