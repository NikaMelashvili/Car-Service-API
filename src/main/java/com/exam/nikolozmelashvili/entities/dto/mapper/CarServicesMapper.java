package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.response.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarServicesRequestDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;

public class CarServicesMapper {

    public static CarServicesDTO toCarServicesDTOWithoutCar(CarServices carServices) {
        if (carServices == null) return null;

        return new CarServicesDTO(carServices.getId(), carServices.getName(), carServices.getDescription(), carServices.getPrice(), null);
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
}
