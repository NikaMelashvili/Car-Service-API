package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.ProvidedServicesDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class CarMapper {

    public static CarDTO toCarDTO(Car car) {
        if (car == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTO(car.getService());
        ProvidedServicesDTO providedServicesDTO = ProvidedServicesMapper.toProvidedServicesDTO(car.getProvidedServices());
        return new CarDTO(car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getLicensePlate(), carServicesDTO, providedServicesDTO);
    }

    public static Car toCar(CarDTO carDTO) {
        if (carDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServices(carDTO.getService());
        ProvidedServices providedServices = ProvidedServicesMapper.toProvidedServices(carDTO.getProvidedService());
        return new Car(carDTO.getId(), carDTO.getMake(), carDTO.getModel(), carDTO.getYear(), carDTO.getLicensePlate(), carServices, providedServices);
    }
}
