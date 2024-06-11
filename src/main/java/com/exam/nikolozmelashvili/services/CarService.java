package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.base.RecordState;
import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.mapper.CarMapper;
import com.exam.nikolozmelashvili.entities.dto.mapper.CarServicesMapper;
import com.exam.nikolozmelashvili.entities.dto.mapper.ProvidedServicesMapper;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.repository.CarRepository;
import com.exam.nikolozmelashvili.repository.CarServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if (carDTO.getService() != null){
            saveCarWithService(carDTO);
        } else {
            saveCarWithoutService(carDTO);
        }
    }

    public void saveCarWithService(CarDTO carDTO){
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

    public void saveCarWithoutService(CarDTO carDTO){
        Car car = CarMapper.toCarWithoutService(carDTO);

        carRepository.save(car);
    }

    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        return CarMapper.toCarDTO(car);
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(CarMapper::toCarDTO)
                .collect(Collectors.toList());
    }

    public void updateCar(Long id, CarDTO carDTO){
        Car updatedCar = CarMapper.toCar(getCarById(id));

        updatedCar.setMake(carDTO.getMake());
        updatedCar.setModel(carDTO.getModel());
        updatedCar.setYear(carDTO.getYear());
        updatedCar.setLicensePlate(carDTO.getLicensePlate());
        updatedCar.setService(CarServicesMapper.toCarServices(carDTO.getService()));
        updatedCar.setProvidedServices(ProvidedServicesMapper.toProvidedServices(carDTO.getProvidedService()));

        carRepository.save(updatedCar);
    }

    public void deactivateCar(Long id){
        Car deactivatedCar = CarMapper.toCar(getCarById(id));
        deactivatedCar.setRecordState(RecordState.INACTIVE);

        carRepository.save(deactivatedCar);
    }

    public void deleteCarSoft(Long id){
        Car car = CarMapper.toCar(getCarById(id));
        car.setRecordState(RecordState.DELETED);

        carRepository.save(car);
    }

    public void deleteCarHard(Long id){
        carRepository.deleteById(id);
    }
}
