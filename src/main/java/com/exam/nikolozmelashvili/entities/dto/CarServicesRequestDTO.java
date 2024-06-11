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
@Schema(description = "DTO for adding a service (carDTO can be null)")
public class CarServicesRequestDTO {

    @Schema(description = "Type name", example = "Oil change")
    private String name;

    @Schema(description = "Type description", example = "Oil was changed")
    private String description;

    @Schema(description = "Service price", example = "85.75")
    private double price;

    @Schema(description = "Latest car that got serviced", example = "1")
    private CarDTO carDTO;
}
