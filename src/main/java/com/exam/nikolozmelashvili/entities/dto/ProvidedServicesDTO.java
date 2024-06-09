package com.exam.nikolozmelashvili.entities.dto;

import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvidedServicesDTO {
    private Long id;
    private CarDTO car;
    private CarServicesDTO carServices;
    private double price;
}
