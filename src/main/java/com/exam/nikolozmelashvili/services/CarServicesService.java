package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.base.RecordState;
import com.exam.nikolozmelashvili.entities.dto.*;
import com.exam.nikolozmelashvili.entities.dto.mapper.CarServicesMapper;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;
import com.exam.nikolozmelashvili.repository.CarRepository;
import com.exam.nikolozmelashvili.repository.CarServiceRepository;
import com.exam.nikolozmelashvili.repository.ProvidedServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServicesService {

    private CarServiceRepository serviceRepository;

    private CarRepository carRepository;

    private ProvidedServicesRepository providedServicesRepository;

    @Autowired
    public void setServiceRepository(CarServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Autowired
    public void setProvidedServicesRepository(ProvidedServicesRepository providedServicesRepository) {
        this.providedServicesRepository = providedServicesRepository;
    }

//    public void insertService(CarServicesRequestDTO service) {
//        if (service.getCarDTO() != null) {
//            insertServiceWithCar(service);
//        } else {
//            insertServiceWithoutCar(service);
//        }
//    }
    public void insertService(CarServicesRequestDTO service) {
        CarServices carServiceEntity = CarServicesMapper.toCarServicesRequest(service);
        serviceRepository.save(carServiceEntity);
    }


    public void getCarServiced(InsertExistingServiceIntoCarDTO carDTO) {
        Optional<Car> carOptional = carRepository.findById(carDTO.getCarId());
        Car car = carOptional.orElseThrow(() -> new RuntimeException("Car by the ID " + carDTO.getCarId() + " wasn't found"));
        if (car.getRecordState() == RecordState.ACTIVE.getValue()) {
            CarServices carServices = serviceRepository.getReferenceById(carDTO.getServiceId());

            ProvidedServices providedServices = new ProvidedServices();
            providedServices.setCar(car);
            providedServices.setCarServices(carServices);
            providedServices.setPrice(carServices.getPrice());

            providedServicesRepository.save(providedServices);
        } else {
            throw new RuntimeException("Car by the ID " + car.getId() + " is not active");
        }
    }

//    private void insertServiceWithCar(CarServicesRequestDTO service) {
//        CarServices carServiceEntity = CarServicesMapper.toCarServicesRequest(service);
//        serviceRepository.save(carServiceEntity);
//    }
//
//    private void insertServiceWithoutCar(CarServicesRequestDTO service) {
//        CarServices carServices = CarServicesMapper.toCarServicesRequest(service);
//        serviceRepository.save(carServices);
//    }

    public Double getRevenueByServiceType(String serviceName) {
        return providedServicesRepository.getTotalRevenueByServiceType(serviceName);
    }

    @Autowired
    public void setCarServiceRepository(CarServiceRepository carServiceRepository) {
        this.serviceRepository = carServiceRepository;
    }
}
