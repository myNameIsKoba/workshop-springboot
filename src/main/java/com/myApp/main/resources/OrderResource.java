package com.myApp.main.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.main.Services.OrderService;
import com.myApp.main.entities.Order;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource{
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> lista = orderService.findAll();

		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = orderService.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
