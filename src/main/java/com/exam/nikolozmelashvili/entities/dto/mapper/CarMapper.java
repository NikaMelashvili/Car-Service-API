package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.request.CarRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarServicesDTO;
import com.exam.nikolozmelashvili.entities.dto.request.ProvidedServicesRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.response.CarResponseDTO;
import com.exam.nikolozmelashvili.entities.dto.response.ProvidedServicesResponseDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class CarMapper {
    //////////////////
    public static Car toCarFromRequest(CarRequestDTO carDTO){
        if (carDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(carDTO.getService());
        ProvidedServices providedServices = ProvidedServicesMapper.toProvidedServicesWithoutCar(carDTO.getProvidedService());
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setService(carServices);
        car.setProvidedServices(providedServices);

        return car;
    }

    public static CarRequestDTO toCarRequestFromCar(Car car){
        if (car == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesDTOWithoutCar(car.getService());
        ProvidedServicesResponseDTO
        CarRequestDTO carDTO = new CarRequestDTO();

    }


    public static CarRequestDTO toCarDTO(Car car) {
        if (car == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(car.getService());
        ProvidedServicesRequestDTO providedServicesDTO = ProvidedServicesMapper.toProvidedServicesDTOWithoutCar(car.getProvidedServices());
        return new CarRequestDTO(car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getLicensePlate(), carServicesDTO, providedServicesDTO);
    }
    //////////////////
    public static CarResponseDTO toCarDTOResponse(Car car) {
        if (car == null) return null;

        CarServicesDTO carServicesDTO = CarServicesMapper.toCarServicesDTOWithoutCar(car.getService());
        ProvidedServicesResponseDTO providedServicesDTO = ProvidedServicesMapper.toProvidedServicesDTOWithoutCar(car.getProvidedServices());
        return new CarResponseDTO(car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getLicensePlate(), carServicesDTO, providedServicesDTO);
    }
    //////////////////


    public static Car toCarConst(CarRequestDTO carDTO) {
        if (carDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(carDTO.getService());
        ProvidedServices providedServices = ProvidedServicesMapper.toProvidedServicesWithoutCar(carDTO.getProvidedService());
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setService(carServices);
        car.setProvidedServices(providedServices);

        return car;
    }
    //////////////////
    public static Car toUpdatedCar(CarRequestDTO carDTO) {
        if (carDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(carDTO.getService());
        ProvidedServices providedServices = ProvidedServicesMapper.toProvidedServicesWithoutCar(carDTO.getProvidedService());
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setService(carServices);
        car.setProvidedServices(providedServices);

        return car;
    }

    public static Car toUpdatedCar(Long id, CarRequestDTO carDTO) {
        if (carDTO == null) return null;

        CarServices carServices = CarServicesMapper.toCarServicesWithoutCar(carDTO.getService());
        ProvidedServices providedServices = ProvidedServicesMapper.toProvidedServicesWithoutCar(carDTO.getProvidedService());
        Car car = new Car();
        car.setId(id);
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setService(carServices);
        car.setProvidedServices(providedServices);

        return car;
    }

    //////////////////
    public static CarRequestDTO toCarDTOWithoutServices(Car car) {
        if (car == null) return null;
        return new CarRequestDTO(car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getLicensePlate(), null, null);
    }
    //////////////////
    public static Car toCarWithoutServices(CarRequestDTO carDTO) {
        if (carDTO == null) return null;
        return new Car(carDTO.getId(), carDTO.getMake(), carDTO.getModel(), carDTO.getYear(),
                carDTO.getLicensePlate(), null, null);
    }
    //////////////////
    public static Car toCarWithoutService(CarRequestDTO carDTO) {
        if (carDTO == null) return null;

        Car car = new Car();
        car.setId(carDTO.getId());
        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setService(null);
        car.setProvidedServices(null);

        return car;
    }
}
