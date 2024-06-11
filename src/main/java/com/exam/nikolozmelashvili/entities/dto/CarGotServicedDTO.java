package com.exam.nikolozmelashvili.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for inserting a service type")
public class CarGotServicedDTO {

    @Schema(description = "Type ID", example = "2")
    private Long id;

    @Schema(description = "Type name", example = "Oil change")
    private String name;

    @Schema(description = "Type description", example = "Oil was changed")
    private String description;

    @Schema(description = "Type price", example = "89.75")
    private double price;
}
