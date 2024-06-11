package com.exam.nikolozmelashvili.entities.dto;

import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for providing a service to a car")
public class ProvidedServicesDTO {

    @Schema(description = "Provided service ID", example = "1")
    private Long id;

    @Schema(description = "Car ID", example = "1")
    private CarDTO car;

    @Schema(description = "Service ID", example = "1")
    private CarServicesDTO carServices;

    @Schema(description = "Price", example = "76.98")
    private double price;
}
