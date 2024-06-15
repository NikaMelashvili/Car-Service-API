package com.exam.nikolozmelashvili.entities.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private CarDTO car;
}
