package com.osc.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    Order findByUserId(Integer userId);
    
}
