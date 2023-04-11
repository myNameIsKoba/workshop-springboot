package com.myApp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.main.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
