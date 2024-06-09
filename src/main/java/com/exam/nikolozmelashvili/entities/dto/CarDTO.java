package com.exam.nikolozmelashvili.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private CarServicesDTO service;
}
