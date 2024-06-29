package com.exam.nikolozmelashvili.entities.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO for registering an account")
public class UserRegisterDTO {

    @Schema(description = "First name", example = "Nika")
    private String firstName;

    @Schema(description = "Last name", example = "Melashvili")
    private String lastName;

    @Schema(description = "Email", example = "nikamela@gmail.com")
    private String email;

    @Schema(description = "Password", example = "Nika123")
    private String password;

    @Schema(description = "Enum role", example = "USER")
    private String role;

    @Schema(description = "(existing) Car ID")
    private CarUpdateDTO car;
}
