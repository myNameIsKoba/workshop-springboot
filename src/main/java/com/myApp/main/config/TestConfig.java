package com.myApp.main.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.myApp.main.entities.Category;
import com.myApp.main.entities.Order;
import com.myApp.main.entities.Product;
import com.myApp.main.entities.User;
import com.myApp.main.entities.enums.OrderStatus;
import com.myApp.main.repositories.CategoryRepository;
import com.myApp.main.repositories.OrderRepository;
import com.myApp.main.repositories.ProductRepository;
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

	@Autowired //Serve para que na hora da execução associe uma 
			   // instancia para este tipo => Injeção de dependencia
	private UserRepository userRepos;

	@Autowired
	private OrderRepository orderRepos;
	
	@Autowired 
	private CategoryRepository categoryRepos;
	
	@Autowired
	private ProductRepository prodRepos;
	
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product( "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", new BigDecimal(90.5), "");
		Product p2 = new Product( "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", new BigDecimal(2190.0), "");
		Product p3 = new Product( "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", new BigDecimal(1250.0), "");
		Product p4 = new Product( "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", new BigDecimal(1200.0), "");
		Product p5 = new Product( 
				"Rails for Dummies", 
				"Cras fringilla convallis sem vel faucibus.", 
				new BigDecimal(100.99), ""); 

		Category c1 = new Category(  "Eletronics");
		Category c2 = new Category(  "Books");
		Category c3 = new Category(  "Computers");
		
		User u1 = new User(  "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(  "Alex Green", "alex@gmail.com", "977777777", "123456");
	
		Order o1 = new Order(  Instant.now(), OrderStatus.CANCELED, u1);
		Order o2 = new Order(  Instant.now(), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(  Instant.now(), OrderStatus.PAID, u2);
		
		this.userRepos.saveAll(Arrays.asList(u1, u2));
		this.orderRepos.saveAll(Arrays.asList(o1, o2, o3));
		this.categoryRepos.saveAll(Arrays.asList(c1, c2, c3));
		this.prodRepos.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		/// Associação entre objetos
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		this.prodRepos.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
}
