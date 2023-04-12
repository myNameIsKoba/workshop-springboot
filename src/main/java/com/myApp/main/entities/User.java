package com.myApp.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Entidade de cadeia de bytes -> 'Serializable'
 * @author User
 *
 */

@Entity
@Table(name = "tb_user")
@NoArgsConstructor(force=true)
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Getter
	@Setter
	private String name;
	@NonNull
	@Getter
	@Setter
	private String email;
	@NonNull
	@Getter
	@Setter
	transient private String password;
	@NonNull
	@Getter
	@Setter
	private String phone;
	@Getter
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	
}
