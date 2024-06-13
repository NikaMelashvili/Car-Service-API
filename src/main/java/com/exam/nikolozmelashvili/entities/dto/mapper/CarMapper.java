package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.CarUpdateDTO;
import com.exam.nikolozmelashvili.entities.dto.ProvidedServicesDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class CarMapper {

    public static CarDTO toCarDTO(Car car) {
        if (car == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(car.getService());
        ProvidedServicesDTO providedServicesDTO = ProvidedServicesMapper.toProvidedServicesDTOWithoutCar(car.getProvidedServices());
        return new CarDTO(car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getLicensePlate(), carServicesDTO, providedServicesDTO);
    }

    public static Car toCar(CarDTO carDTO) {
        if (carDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(carDTO.getService());
        ProvidedServices providedServices = ProvidedServicesMapper.toProvidedServicesWithoutCar(carDTO.getProvidedService());
        return new Car(carDTO.getId(), carDTO.getMake(), carDTO.getModel(), carDTO.getYear(), carDTO.getLicensePlate(), carServices, providedServices);
    }

    public static Car toCarWithoutServices(CarDTO carDTO) {
        if (carDTO == null) return null;
        return new Car(carDTO.getId(), carDTO.getMake(), carDTO.getModel(), carDTO.getYear(), carDTO.getLicensePlate(), null, null);
    }

    public static Car toCarFromUpdate(CarUpdateDTO carDTO){
        if (carDTO == null) return null;

        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlate(carDTO.getLicensePlate());

        return car;
    }
}
