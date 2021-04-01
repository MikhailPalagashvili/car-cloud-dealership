package com.grantcs.cardealership.bootstrap;


import com.grantcs.cardealership.domain.Car;
import com.grantcs.cardealership.domain.Owner;
import com.grantcs.cardealership.domain.User;
import com.grantcs.cardealership.repository.CarRepository;
import com.grantcs.cardealership.repository.OwnerRepository;
import com.grantcs.cardealership.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final UserRepository userRepository;

    public DataLoader(final CarRepository carRepository, final OwnerRepository ownerRepository, final UserRepository userRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (carRepository.count() == 0) {
            loadData();
        }
    }

    private void loadData() {
        log.info("Loading startup data...");

        Owner owner1 = Owner
                .builder()
                .firstName("Lebron")
                .lastName("James")
                .build();
        ownerRepository.save(owner1);

        Owner owner2 = Owner
                .builder()
                .firstName("Kevin")
                .lastName("Durant")
                .build();
        ownerRepository.save(owner2);

        Car car1 = Car
                .builder()
                .brand("Honda")
                .model("Accord")
                .color("Black")
                .registerNumber("1234")
                .year(2017)
                .price(25000)
                .owner(owner1)
                .build();
        carRepository.save(car1);

        Car car2 = Car
                .builder()
                .brand("Toyota")
                .model("Camry")
                .color("Metallic")
                .registerNumber("2345")
                .year(2020)
                .price(30000)
                .owner(owner2)
                .build();
        carRepository.save(car2);

        Car car3 = Car
                .builder()
                .brand("Nissan")
                .model("Maxima")
                .color("Red")
                .registerNumber("1010")
                .year(2021)
                .price(40000)
                .owner(owner2)
                .build();
        carRepository.save(car3);

        //password: kingjames
        User user1 = User
                .builder()
                .username("lebron")
                .password("$2a$10$lqr5ukFfSyrI4/GrrFocd.w7TuMN9OiOmhYg7IldfD4brCCMXIr6q")
                .role("USER")
                .build();
        userRepository.save(user1);

        //password:iamthegoat
        User user2 = User
                .builder()
                .username("kevin")
                .password("$2a$10$X/lY19E2pAV3.y8C4nM27.9SvOnJFmlFkAOTSF/lNFflucAKtOk0i")
                .role("USER")
                .build();
        userRepository.save(user2);

        //password: admin
        User admin = User
                .builder()
                .username("admin")
                .password("$2a$10$3aVX4y4QY84ence6fMJumuYxPp7cmGABRbBwOw7Z8EOasoQUix2VG")
                .role("ADMIN")
                .build();
        userRepository.save(admin);
    }
}
