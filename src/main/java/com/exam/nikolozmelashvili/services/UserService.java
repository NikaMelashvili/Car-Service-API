package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.dto.request.UserRegisterDTO;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.User;
import com.exam.nikolozmelashvili.repository.CarRepository;
import com.exam.nikolozmelashvili.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private CarRepository carRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Long addUser(UserRegisterDTO registerDTO) {
        if (registerDTO.getUsername() == null || registerDTO.getPassword() == null || registerDTO.getEmail() == null) {
            throw new RuntimeException("All fields are required");
        }
        if (validateEmail(registerDTO.getEmail())) {
            throw new RuntimeException("Email already used");
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setEmail(registerDTO.getEmail());

        Car car = carRepository.findById(registerDTO.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));
        user.setCar(car);

        userRepository.save(user);
        return user.getId();
    }

    public boolean validateEmail(String email) {
        return userRepository.validateEmail(email);
    }

}
