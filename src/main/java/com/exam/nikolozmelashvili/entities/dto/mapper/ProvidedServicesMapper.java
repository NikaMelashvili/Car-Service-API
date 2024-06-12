package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.ProvidedServicesDTO;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class ProvidedServicesMapper {

    public static ProvidedServicesDTO toProvidedServicesDTOWithoutCar(ProvidedServices providedServices) {
        if (providedServices == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(providedServices.getCarServices());
        return new ProvidedServicesDTO(providedServices.getId(), null, carServicesDTO, providedServices.getPrice());
    }

    public static ProvidedServices toProvidedServicesWithoutCar(ProvidedServicesDTO providedServicesDTO) {
        if (providedServicesDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(providedServicesDTO.getCarServices());
        return new ProvidedServices(providedServicesDTO.getId(), null, carServices, providedServicesDTO.getPrice());
    }
}
