package com.exam.nikolozmelashvili.entities.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarServicedRequestDTO {
    private CarGotServicedDTO carService;
    private CarIdDTO carId;
}