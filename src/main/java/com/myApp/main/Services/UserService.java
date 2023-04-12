package com.myApp.main.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp.main.entities.User;
import com.myApp.main.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repositorio;
	
	public List<User> findAll(){
		return repositorio.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repositorio.findById(id);
		
		return obj.get();
	}
	
	public User insert(User user) {
		return repositorio.save(user);
	}
	
	public User update(Long id, User user) {
		User entity = repositorio.getReferenceById(id);
		updateData(entity, user);
		
		return repositorio.save(entity);
	}
	
	private void updateData(User entity, User user) {
		// TODO Auto-generated method stub
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}
}
