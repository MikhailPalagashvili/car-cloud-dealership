package com.grantcs.cardealership;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CarDealershipApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarDealershipApplication.class, args);
        log.info("Welcome to the Car Cloud Dealership!");
    }

}
