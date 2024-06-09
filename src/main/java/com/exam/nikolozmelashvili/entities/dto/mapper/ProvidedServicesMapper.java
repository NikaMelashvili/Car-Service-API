package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.ProvidedServicesDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class ProvidedServicesMapper {

    public static ProvidedServicesDTO toProvidedServicesDTO(ProvidedServices providedServices) {
        if (providedServices == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTO(providedServices.getCarServices());
        CarDTO carDTO = CarMapper.toCarDTO(providedServices.getCar());
        return new ProvidedServicesDTO(providedServices.getId(), carDTO, carServicesDTO, providedServices.getPrice());
    }

    public static ProvidedServices toProvidedServices(ProvidedServicesDTO providedServicesDTO) {
        if (providedServicesDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServices(providedServicesDTO.getCarServices());
        Car car = CarMapper.toCar(providedServicesDTO.getCar());
        return new ProvidedServices(providedServicesDTO.getId(), car, carServices, providedServicesDTO.getPrice());
    }
}
