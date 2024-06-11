package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.request.CarServicedRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.request.InsertExistingServiceIntoCarDTO;
import com.exam.nikolozmelashvili.entities.dto.response.ProvidedServicesResponseDTO;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;
import com.exam.nikolozmelashvili.services.CarServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/services")
public class CarServiceController {

    private final CarServicesService carServicesService;

    @Autowired
    public CarServiceController(CarServicesService carServicesService) {
        this.carServicesService = carServicesService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> saveCarService(@RequestBody CarServicesDTO carService) {
        carServicesService.insertService(carService);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/add-existing")
    public ResponseEntity<Void> addExistingServiceToCar(@RequestBody InsertExistingServiceIntoCarDTO carDTO) {
        carServicesService.getCarServiced(carDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{serviceName}/revenue")
    public ResponseEntity<Double> getRevenueByServiceType(@PathVariable String serviceName) {
        double revenue = carServicesService.getRevenueByServiceType(serviceName);
        return new ResponseEntity<>(revenue, HttpStatus.OK);
    }

    @GetMapping("/get-service/{id}")
    public ResponseEntity<ProvidedServicesResponseDTO> getProvidedService(@PathVariable Long id){
        ProvidedServicesResponseDTO providedServices = carServicesService.getProvidedService(id);
        return new ResponseEntity<>(providedServices, HttpStatus.OK);
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
