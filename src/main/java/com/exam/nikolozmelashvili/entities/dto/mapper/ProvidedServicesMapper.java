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

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(providedServices.getCarServices());
        CarDTO carDTO = CarMapper.toCarDTOWithoutServices(providedServices.getCar());
        return new ProvidedServicesDTO(providedServices.getId(), carDTO, carServicesDTO, providedServices.getPrice());
    }

    public static ProvidedServicesDTO toProvidedServicesDTOWithoutCar(ProvidedServices providedServices) {
        if (providedServices == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(providedServices.getCarServices());
        return new ProvidedServicesDTO(providedServices.getId(), null, carServicesDTO, providedServices.getPrice());
    }

    public static ProvidedServices toProvidedServices(ProvidedServicesDTO providedServicesDTO) {
        if (providedServicesDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(providedServicesDTO.getCarServices());
        Car car = CarMapper.toCarWithoutServices(providedServicesDTO.getCar());
        return new ProvidedServices(providedServicesDTO.getId(), car, carServices, providedServicesDTO.getPrice());
    }

    public static ProvidedServices toProvidedServicesWithoutCar(ProvidedServicesDTO providedServicesDTO) {
        if (providedServicesDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(providedServicesDTO.getCarServices());
        return new ProvidedServices(providedServicesDTO.getId(), null, carServices, providedServicesDTO.getPrice());
    }
}
