package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.request.CarRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarGotServicedDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;

public class CarServicesMapper {

    public static CarServicesDTO toCarServicesDTO(CarServices carServices) {
        if (carServices == null) return null;

        CarRequestDTO carDTO = CarMapper.toCarDTOWithoutServices(carServices.getCar());
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
