package com.myApp.main.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.myApp.main.entities.User;
import com.myApp.main.repositories.UserRepository;

@Configuration
@Profile("test") // usado apenas com este perfil em application.properties
/**
 * implements -> "CommandLineRunner"
 * Executa quando a aplicação for iniciada dentro do método run
 * @author User
 *
 */
public class TestConfig implements CommandLineRunner{

	@Autowired //Serve para que na hora da execução associe uma instancia para este tipo
	private UserRepository userRepos;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
		this.userRepos.saveAll(Arrays.asList(u1, u2));
	}
}
