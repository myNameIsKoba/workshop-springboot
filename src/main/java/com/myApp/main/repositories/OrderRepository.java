package com.myApp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.main.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
