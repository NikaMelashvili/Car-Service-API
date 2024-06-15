package com.exam.nikolozmelashvili.entities.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for car")
public class CarDTO {

    @Schema(description = "Car ID", example = "107")
    private Long id;

    @Schema(description = "Car Make (Brand)", example = "Ferrari")
    private String make;

    @Schema(description = "Car Model", example = "488 Pista")
    private String model;

    @Schema(description = "Car Registered Year", example = "2019")
    private int year;

    @Schema(description = "Car Licence plate", example = "NI-001-KA")
    private String licensePlate;

    @Schema(description = "Car's Latest service", example = "3")
    private CarServicesDTO service;

    @Schema(description = "Car's Latest provided service", example = "3")
    private ProvidedServicesDTO providedService;
}
