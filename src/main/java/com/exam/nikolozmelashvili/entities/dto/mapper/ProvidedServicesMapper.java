package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.ProvidedServicesDTO;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class ProvidedServicesMapper {

    public static ProvidedServicesDTO toProvidedServicesDTO(ProvidedServices providedServices) {
        if (providedServices == null) return null;

        return new ProvidedServicesDTO(providedServices.getId(), CarMapper.toCarDTO(providedServices.getCar()), CarServicesMapper.toCarServicesDTO(providedServices.getCarServices()), providedServices.getPrice());
    }

    public static ProvidedServices toProvidedServices(ProvidedServicesDTO providedServicesDTO) {
        if (providedServicesDTO == null) return null;

        return new ProvidedServices(providedServicesDTO.getId(), CarMapper.toCar(providedServicesDTO.getCar()), CarServicesMapper.toCarServices(providedServicesDTO.getCarServices()), providedServicesDTO.getPrice());
    }
}
