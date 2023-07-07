package com.challenge.ChallengeConstruoAG.repositories;

import com.challenge.ChallengeConstruoAG.entities.Order;
import com.challenge.ChallengeConstruoAG.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
