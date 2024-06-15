package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.request.CarServicesRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.request.InsertExistingServiceIntoCarDTO;
import com.exam.nikolozmelashvili.services.CarServicesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Services", description = "Operations related to servicing cars")
@RestController
@RequestMapping("/rest/services")
public class CarServiceController {

    private final CarServicesService carServicesService;

    @Autowired
    public CarServiceController(CarServicesService carServicesService) {
        this.carServicesService = carServicesService;
    }

    @Operation(summary = "Add a new service type (you can also add a car or just say null)")
    @PostMapping("/add-service")
    public ResponseEntity<Void> saveCarService(@RequestBody CarServicesRequestDTO carService) {
        carServicesService.insertService(carService);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Perform a service on an existing car")
    @PostMapping("/get-serviced")
    public ResponseEntity<Void> addExistingServiceToCar(@RequestBody InsertExistingServiceIntoCarDTO carDTO) {
        carServicesService.getCarServiced(carDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get the full revenue by a Service type name (example: Oil change)")
    @GetMapping("/{serviceName}/revenue")
    public ResponseEntity<Double> getRevenueByServiceType(@PathVariable String serviceName) {
        double revenue = carServicesService.getRevenueByServiceType(serviceName);
        return new ResponseEntity<>(revenue, HttpStatus.OK);
    }
}
