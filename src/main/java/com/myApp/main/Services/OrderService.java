package com.myApp.main.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp.main.entities.Order;
import com.myApp.main.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repositorio;
	
	public List<Order> findAll(){
		return repositorio.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repositorio.findById(id);
		
		return obj.get();
	}
}
