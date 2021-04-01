package com.grantcs.cardealership.controller;

import com.grantcs.cardealership.domain.Car;
import com.grantcs.cardealership.repository.CarRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @CrossOrigin
    @GetMapping
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

}
