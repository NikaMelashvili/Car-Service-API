package com.exam.nikolozmelashvili.controller;

import com.exam.nikolozmelashvili.entities.dto.request.UserRegisterDTO;
import com.exam.nikolozmelashvili.entities.dto.response.UserDTO;
import com.exam.nikolozmelashvili.entities.model.User;
import com.exam.nikolozmelashvili.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
@Tag(name = "Users", description = "Operations related to Users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    @Operation(description = "Registration form")
    public ResponseEntity<Long> addUser(UserRegisterDTO registerDTO) {
        Long userId = userService.addUser(registerDTO);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }
}
