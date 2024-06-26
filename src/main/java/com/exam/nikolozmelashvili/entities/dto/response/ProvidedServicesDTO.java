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
@Schema(description = "DTO for providing a service to a car")
public class ProvidedServicesDTO {

    @Schema(description = "Provided service ID", example = "1")
    private Long id;

    @Schema(description = "Car ID", example = "1")
    private CarDTO car;

    @Schema(description = "Service ID", example = "1")
    private CarServicesDTO carServices;
}
