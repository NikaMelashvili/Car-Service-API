package com.exam.nikolozmelashvili.entities.dto.response;

import com.exam.nikolozmelashvili.entities.dto.request.CarRequestDTO;
import com.exam.nikolozmelashvili.entities.dto.request.CarServicesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProvidedServicesResponseDTO {
    private Long id;
    private CarRequestDTO car;
    private CarServicesDTO carServices;
    private double price;
}
