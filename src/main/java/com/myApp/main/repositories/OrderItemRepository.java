package com.myApp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.main.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
