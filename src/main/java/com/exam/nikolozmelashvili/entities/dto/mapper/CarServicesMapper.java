package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.CarGotServicedDTO;
import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.repository.CarRepository;

public class CarServicesMapper {

    public static CarServicesDTO toCarServicesDTO(CarServices carServices) {
        if (carServices == null) return null;

        CarDTO carDTO = CarMapper.toCarDTO(carServices.getCar());
        return new CarServicesDTO(carServices.getId(), carServices.getName(), carServices.getDescription(), carServices.getPrice(), carDTO);
    }

    public static CarServices toCarServices(CarServicesDTO carServicesDTO) {
        if (carServicesDTO == null) return null;

        Car car = CarMapper.toCar(carServicesDTO.getCarDTO());
        return new CarServices(carServicesDTO.getId(), carServicesDTO.getName(), carServicesDTO.getDescription(), carServicesDTO.getPrice(), car);
    }

    public static CarServices toCarService(CarGotServicedDTO carGotServicedDTO, Car car, CarRepository carRepository) {
        if (carGotServicedDTO == null) return null;

        return new CarServices(carGotServicedDTO.getId(), carGotServicedDTO.getName(), carGotServicedDTO.getDescription(), carGotServicedDTO.getPrice(), car);
    }
}