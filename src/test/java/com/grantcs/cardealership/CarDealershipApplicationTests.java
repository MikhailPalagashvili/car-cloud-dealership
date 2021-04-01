package com.grantcs.cardealership;

import com.grantcs.cardealership.controller.CarController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@RunWith(SpringRunner.class)
@SpringBootTest
class CarDealershipApplicationTests {

    @Autowired
    private CarController carController;

    @Test
    void contextLoads() {
        assertThat(carController).isNotNull();
    }

}
