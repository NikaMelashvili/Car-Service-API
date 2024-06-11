package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.request.CarRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.request.ProvidedServicesRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.response.ProvidedServicesResponseDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class ProvidedServicesMapper {

    public static ProvidedServicesRequestDTO toProvidedServicesDTO(ProvidedServices providedServices) {
        if (providedServices == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(providedServices.getCarServices());
        CarRequestDTO carDTO = CarMapper.toCarDTOWithoutServices(providedServices.getCar());
        return new ProvidedServicesRequestDTO(providedServices.getId(), carDTO, carServicesDTO, providedServices.getPrice());
    }

    public static ProvidedServicesResponseDTO toProvidedServicesDTOWithoutCar(ProvidedServices providedServices) {
        if (providedServices == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(providedServices.getCarServices());
        return new ProvidedServicesResponseDTO(providedServices.getId(), null, carServicesDTO, providedServices.getPrice());
    }

    public static ProvidedServices toProvidedServices(ProvidedServicesRequestDTO providedServicesDTO) {
        if (providedServicesDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(providedServicesDTO.getCarServices());
        Car car = CarMapper.toCarWithoutServices(providedServicesDTO.getCar());
        return new ProvidedServices(providedServicesDTO.getId(), car, carServices, providedServicesDTO.getPrice());
    }

    public static ProvidedServices toProvidedServicesWithoutCar(ProvidedServicesRequestDTO providedServicesDTO) {
        if (providedServicesDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(providedServicesDTO.getCarServices());
        return new ProvidedServices(providedServicesDTO.getId(), null, carServices, providedServicesDTO.getPrice());
    }
}
