package com.exam.nikolozmelashvili.entities.dto.response;

import com.exam.nikolozmelashvili.entities.dto.request.CarServicesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDTO {
    private Long id;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private CarServicesDTO service;
    private ProvidedServicesResponseDTO servicesResponseDTO;
}
