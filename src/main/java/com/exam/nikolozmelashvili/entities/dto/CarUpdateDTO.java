package com.exam.nikolozmelashvili.entities.dto;

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
public class CarUpdateDTO {

    @Schema(description = "Car Make (Brand)", example = "Ferrari")
    private String make;

    @Schema(description = "Car Model", example = "488 Pista")
    private String model;

    @Schema(description = "Car Registered Year", example = "2019")
    private int year;

    @Schema(description = "Car Licence plate", example = "NI-001-KA")
    private String licensePlate;
}
