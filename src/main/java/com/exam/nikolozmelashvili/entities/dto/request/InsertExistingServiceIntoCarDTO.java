package com.exam.nikolozmelashvili.entities.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InsertExistingServiceIntoCarDTO {
    Long carId;
    Long serviceId;
}
