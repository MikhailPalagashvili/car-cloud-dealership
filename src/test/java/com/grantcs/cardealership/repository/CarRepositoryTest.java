package com.grantcs.cardealership.repository;

import com.grantcs.cardealership.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveCar() {
        Car car = Car.builder()
                .brand("BMW")
                .model("3-Series")
                .color("Blue")
                .registerNumber("12356")
                .year(1994)
                .price(5000)
                .build();
        testEntityManager.persistAndFlush(car);
        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars() {
        Car car1 = Car.builder()
                .brand("BMW")
                .model("3-Series")
                .color("Blue")
                .registerNumber("12356")
                .year(1994)
                .price(5000)
                .build();

        Car car2 = Car.builder()
                .brand("Range Rover")
                .model("Sport")
                .color("Blue")
                .registerNumber("12356")
                .year(2020)
                .price(90000)
                .build();

        testEntityManager.persistAndFlush(car1);
        testEntityManager.persistAndFlush(car2);
        carRepository.deleteAll();
        assertThat(carRepository.findAll()).isEmpty();
    }
}