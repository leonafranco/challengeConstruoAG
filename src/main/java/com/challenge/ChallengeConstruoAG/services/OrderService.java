package com.challenge.ChallengeConstruoAG.services;

import com.challenge.ChallengeConstruoAG.entities.Order;
import com.challenge.ChallengeConstruoAG.entities.OrderProduct;
import com.challenge.ChallengeConstruoAG.entities.Product;
import com.challenge.ChallengeConstruoAG.entities.User;
import com.challenge.ChallengeConstruoAG.repositories.OrderProductRepository;
import com.challenge.ChallengeConstruoAG.repositories.OrderRepository;
import com.challenge.ChallengeConstruoAG.repositories.ProductRepository;
import com.challenge.ChallengeConstruoAG.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Integer id) {
        Optional<Order> o = repository.findById(id);
        return o.get();
    }

    public Order insert(Order u) {
        return repository.save(u);
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public OrderProduct addCart(Integer orderId, Integer productId, Integer quantity) {
        Optional<Product> p = productRepository.findById(productId);
        Optional<Order> o = repository.findById(orderId);
        if (!p.isPresent()) throw new IllegalArgumentException("Product not found");
        if (!p.isPresent()) throw new IllegalArgumentException("Product not found");
        if (!p.isPresent()) throw new IllegalArgumentException("Product not found");
        Product product = p.get();
        Order order = o.get();
        OrderProduct orderProduct = new OrderProduct(order, product, quantity, product.getPrice());
        orderProductRepository.save(orderProduct);

        return orderProduct;

    }
}
