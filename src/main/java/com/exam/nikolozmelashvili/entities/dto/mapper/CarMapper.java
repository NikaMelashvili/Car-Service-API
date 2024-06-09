package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.model.Car;

public class CarMapper {

    public static CarDTO toCarDTO(Car car) {
        if (car == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTO(car.getService());
        return new CarDTO(car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getLicensePlate(), carServicesDTO);
    }

    public static Car toCar(CarDTO carDTO) {
        if (carDTO == null) return null;

        return new Car(carDTO.getId(), carDTO.getMake(), carDTO.getModel(), carDTO.getYear(), carDTO.getLicensePlate(), CarServicesMapper.toCarServices(carDTO.getService()));
    }
}

