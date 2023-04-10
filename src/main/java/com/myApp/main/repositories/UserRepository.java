package com.myApp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.main.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
