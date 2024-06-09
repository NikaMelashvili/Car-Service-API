package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.base.RecordState;
import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.mapper.CarMapper;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.repository.CarRepository;
import com.exam.nikolozmelashvili.repository.CarServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarRepository carRepository;

    private CarServiceRepository serviceRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Autowired
    public void setServiceRepository(CarServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void saveCar(CarDTO carDTO) {
        Car car = CarMapper.toCar(carDTO);

        CarServices service = car.getService();
        if (service.getId() == null) {
            service = serviceRepository.save(service);
        } else {
            service = serviceRepository.findById(service.getId()).orElse(service);
        }

        car.setService(service);
        car.setRecordState(RecordState.ACTIVE);

        carRepository.save(car);
    }
}
