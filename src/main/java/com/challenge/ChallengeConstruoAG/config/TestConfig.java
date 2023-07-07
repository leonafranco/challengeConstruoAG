package com.challenge.ChallengeConstruoAG.config;


import com.challenge.ChallengeConstruoAG.entities.Order;
import com.challenge.ChallengeConstruoAG.entities.OrderProduct;
import com.challenge.ChallengeConstruoAG.entities.Product;
import com.challenge.ChallengeConstruoAG.entities.User;
import com.challenge.ChallengeConstruoAG.repositories.OrderProductRepository;
import com.challenge.ChallengeConstruoAG.repositories.OrderRepository;
import com.challenge.ChallengeConstruoAG.repositories.ProductRepository;
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
    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private ProductRepository productRepository;

    Instant instant = Instant.now();
    long timeStampMillis = instant.toEpochMilli();

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Leonardo Franco", "leonardomf96@gmail.com", "123456");
        User u2 = new User(null, "Bulbasaur", "Bulbasaur@gmail.com", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));


        Order o1 = new Order(null, timeStampMillis, u1);
        Order o2 = new Order(null, timeStampMillis, u1);
        Order o3 = new Order(null, timeStampMillis, u2);


        orderRepository.saveAll(Arrays.asList(o1,o2));

        Product p1 = new Product(null, "Tomato", "fruit", 100);
        Product p2 = new Product(null, "lettuce", "vegetable", 50);
        Product p3 = new Product(null, "potato", "vegetable", 25);
        Product p4 = new Product(null, "bananas", "fruit", 10);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        OrderProduct op1 = new OrderProduct(o1,p2,5, p2.getPrice());
        OrderProduct op2 = new OrderProduct(o1,p3,3, p3.getPrice());
        OrderProduct op3 = new OrderProduct(o1,p1,2, p1.getPrice());

        orderProductRepository.saveAll(Arrays.asList(op1,op2,op3));




    }
}
