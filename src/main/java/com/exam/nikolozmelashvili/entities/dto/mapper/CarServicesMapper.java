package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.model.CarServices;

public class CarServicesMapper {

    public static CarServicesDTO toCarServicesDTO(CarServices carServices) {
        if (carServices == null) return null;

        return new CarServicesDTO(carServices.getId(), carServices.getName(), carServices.getDescription(), carServices.getPrice());
    }

    public static CarServices toCarServices(CarServicesDTO carServicesDTO) {
        if (carServicesDTO == null) return null;

        return new CarServices(carServicesDTO.getId(), carServicesDTO.getName(), carServicesDTO.getDescription(), carServicesDTO.getPrice());
    }
}
