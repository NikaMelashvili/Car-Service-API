package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.CarServicedRequestDTO;
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

    @PostMapping("/serviced")
    public ResponseEntity<Void> getCarServiced(@RequestBody CarServicedRequestDTO carServicedRequest) {
        carServicesService.getCarServiced(carServicedRequest.getCarService(), carServicedRequest.getCarId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/engine-check")
    public ResponseEntity<Void> getEngineChecked(@RequestBody CarServicedRequestDTO carServicedRequest) {
        carServicesService.getCarServiced(carServicedRequest.getCarService(), carServicedRequest.getCarId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/oil-change")
    public ResponseEntity<Void> getOilChanged(@RequestBody CarServicedRequestDTO carServicedRequest) {
        carServicesService.getCarServiced(carServicedRequest.getCarService(), carServicedRequest.getCarId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/new-wheels")
    public ResponseEntity<Void> getNewWheels(@RequestBody CarServicedRequestDTO carServicedRequest) {
        carServicesService.getCarServiced(carServicedRequest.getCarService(), carServicedRequest.getCarId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
