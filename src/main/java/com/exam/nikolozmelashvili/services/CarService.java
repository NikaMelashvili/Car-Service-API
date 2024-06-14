package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.base.RecordState;
import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.CarUpdateDTO;
import com.exam.nikolozmelashvili.entities.dto.mapper.CarMapper;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(CarUpdateDTO carDTO) {
        Car car = CarMapper.toCarFromUpdate(carDTO);
        car.setRecordState(RecordState.ACTIVE.getValue());
        carRepository.save(car);
    }

    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        return CarMapper.toCarDTO(car);
    }

    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(CarMapper::toCarDTO)
                .collect(Collectors.toList());
    }

    public void updateCar(Long id, CarUpdateDTO carDTO) {
        Optional<Car> optionalCar = carRepository.findById(id);
        Car updatedCar = optionalCar.get();
        Integer recordState = updatedCar.getRecordState();

        if (recordState != null && recordState == RecordState.ACTIVE.getValue()) {
            updatedCar.setMake(carDTO.getMake());
            updatedCar.setModel(carDTO.getModel());
            updatedCar.setYear(carDTO.getYear());
            updatedCar.setLicensePlate(carDTO.getLicensePlate());

            carRepository.save(updatedCar);
        } else {
            throw new RuntimeException("Car has an invalid state");
        }
    }


    public void changeCarState(Integer state, Long carId){
        if (state > 3 || state < 1){
            throw new RuntimeException("state cant be more than 3 or less than 1");
        }
        Optional<Car> carOptional = carRepository.findById(carId);
        Car car = carOptional.get();

        car.setRecordState(state);
        carRepository.save(car);
    }

    public void deactivateCar(Long id){
        Car deactivatedCar = carRepository.getReferenceById(id);
        Integer recordState = deactivatedCar.getRecordState();

        if (recordState != null && recordState == RecordState.DELETED.getValue()
        || recordState != null && recordState == RecordState.INACTIVE.getValue()){
            throw new RuntimeException("The car has either been deleted or deactivated");
        } else {
            deactivatedCar.setRecordStateEnum(RecordState.INACTIVE);

            carRepository.save(deactivatedCar);
        }
    }

    public void deleteCarSoft(Long id){
        Car car = CarMapper.toCar(getCarById(id));
        car.setRecordStateEnum(RecordState.DELETED);

        carRepository.save(car);
    }

    public void deleteCarHard(Long id){
        carRepository.deleteById(id);
    }
}
