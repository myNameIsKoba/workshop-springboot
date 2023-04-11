package com.myApp.main.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp.main.entities.Product;
import com.myApp.main.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repositorio;
	
	public List<Product> findAll(){
		return repositorio.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repositorio.findById(id);
		
		return obj.get();
	}
}
