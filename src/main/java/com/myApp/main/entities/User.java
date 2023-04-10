package com.myApp.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade de cadeia de bytes -> 'Serializable'
 * @author User
 *
 */

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String phone;
	@Getter
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	public User(Long id, String name, String email, String pass, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = pass;
		this.phone = phone;
	}
}
