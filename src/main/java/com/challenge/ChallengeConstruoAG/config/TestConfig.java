package com.challenge.ChallengeConstruoAG.config;


import com.challenge.ChallengeConstruoAG.entities.Order;
import com.challenge.ChallengeConstruoAG.entities.User;
import com.challenge.ChallengeConstruoAG.repositories.OrderRepository;
import com.challenge.ChallengeConstruoAG.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    Instant instant = Instant.now();
    long timeStampMillis = instant.toEpochMilli();

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Leonardo Franco", "leonardomf96@gmail.com", "123456");
        User u2 = new User(null, "Bulbasaur", "Bulbasaur@gmail.com", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));


        Order o1 = new Order(null, timeStampMillis);
        Order o2 = new Order(null, timeStampMillis);

        orderRepository.saveAll(Arrays.asList(o1,o2));




    }
}
