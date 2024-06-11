package com.exam.nikolozmelashvili.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for inserting an existing car into an existing service")
public class InsertExistingServiceIntoCarDTO {

    @Schema(description = "Car ID", example = "1")
    Long carId;

    @Schema(description = "Service ID", example = "1")
    Long serviceId;
}
