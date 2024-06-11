package com.exam.nikolozmelashvili.entities.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarServicesDTO {
    private String name;
    private String description;
    private double price;
    private CarRequestDTO carDTO;
}