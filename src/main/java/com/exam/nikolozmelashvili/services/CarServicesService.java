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

    public RecordState carStatusCheck(RecordState state){
        if (state.equals(RecordState.ACTIVE)){
            return RecordState.ACTIVE;
        }

        if (state.equals(RecordState.INACTIVE)){
            return RecordState.INACTIVE;
        }

        if (state.equals(RecordState.DELETED)){
            return RecordState.DELETED;
        }
        return null;
    }

    public void insertService(CarServicesDTO service) {
        if (service.getCarDTO() != null) {
            insertServiceWithCar(service);
        } else {
            insertServiceWithoutCar(service);
        }
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

    private void insertServiceWithCar(CarServicesDTO service) {
        CarServices carServiceEntity = CarServicesMapper.toCarServices(service);
        serviceRepository.save(carServiceEntity);
    }

    private void insertServiceWithoutCar(CarServicesDTO service) {
        CarServices carServices = CarServicesMapper.toCarServicesWithoutServices(service);
        serviceRepository.save(carServices);
    }

    public void getCarServiced(CarGotServicedDTO carServicesDTO, CarIdDTO id) {
        Long carId = id.getCarId();
        Optional<Car> car = carRepository.findById(carId);
        Car carEntity = car.get();

        CarServices carServices = CarServicesMapper.toCarService(carServicesDTO, carEntity);
        serviceRepository.save(carServices);

        carRepository.save(carEntity);

        ProvidedServices providedServices = new ProvidedServices();
        providedServices.setCar(carEntity);
        providedServices.setCarServices(carServices);
        providedServices.setPrice(carServices.getPrice());

        Optional<Car> carGotServiced = carRepository.findById(carId);
        Car carProvidedServices = carGotServiced.get();

        carProvidedServices.setProvidedServices(providedServices);
        carRepository.save(carProvidedServices);

        providedServicesRepository.save(providedServices);
    }

    public ProvidedServices getProvidedService(Long id) {
        Optional<ProvidedServices> providedServices = providedServicesRepository.findById(id);
        ProvidedServices service = providedServices.get();
        return service;
    }

    public Double getRevenueByServiceType(String serviceName) {
        return providedServicesRepository.getTotalRevenueByServiceType(serviceName);
    }

    @Autowired
    public void setCarServiceRepository(CarServiceRepository carServiceRepository) {
        this.serviceRepository = carServiceRepository;
    }
}
