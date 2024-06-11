package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.CarGotServicedDTO;
import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.CarServicesRequestDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.repository.CarRepository;

public class CarServicesMapper {

    public static CarServicesDTO toCarServicesDTO(CarServices carServices) {
        if (carServices == null) return null;

        CarDTO carDTO = CarMapper.toCarDTOWithoutServices(carServices.getCar());
        return new CarServicesDTO(carServices.getId(), carServices.getName(), carServices.getDescription(), carServices.getPrice(), carDTO);
    }

    public static CarServicesDTO toCarServicesDTOWithoutCar(CarServices carServices) {
        if (carServices == null) return null;

        return new CarServicesDTO(carServices.getId(), carServices.getName(), carServices.getDescription(), carServices.getPrice(), null);
    }

    public static CarServices toCarServices(CarServicesDTO carServicesDTO) {
        if (carServicesDTO == null) return null;

        Car car = CarMapper.toCarWithoutServices(carServicesDTO.getCarDTO());
        return new CarServices(carServicesDTO.getId(), carServicesDTO.getName(), carServicesDTO.getDescription(), carServicesDTO.getPrice(), car);
    }

    public static CarServices toCarServicesRequest(CarServicesRequestDTO carServicesDTO) {
        if (carServicesDTO == null) return null;

        CarServices carServices = new CarServices();
        carServices.setName(carServicesDTO.getName());
        carServices.setDescription(carServicesDTO.getDescription());
        carServices.setPrice(carServicesDTO.getPrice());

        if (carServicesDTO.getCarDTO() != null) {
            Car car = CarMapper.toCarWithoutServices(carServicesDTO.getCarDTO());
            carServices.setCar(car);
        }

        return carServices;
    }

    public static CarServices toCarServicesWithoutCar(CarServicesDTO carServicesDTO) {
        if (carServicesDTO == null) return null;

        return new CarServices(carServicesDTO.getId(), carServicesDTO.getName(), carServicesDTO.getDescription(), carServicesDTO.getPrice(), null);
    }

    public static CarServices toCarService(CarGotServicedDTO carGotServicedDTO, Car car) {
        if (carGotServicedDTO == null) return null;

        return new CarServices(carGotServicedDTO.getId(), carGotServicedDTO.getName(), carGotServicedDTO.getDescription(), carGotServicedDTO.getPrice(), car);
    }

    public static CarServices toCarServicesWithoutServices(CarServicesDTO service){
        if (service == null) return null;

        CarServices carServices = new CarServices();
        carServices.setId(service.getId());
        carServices.setName(service.getName());
        carServices.setDescription(service.getDescription());
        carServices.setPrice(service.getPrice());

        return carServices;
    }
}
