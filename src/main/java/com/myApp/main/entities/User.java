package com.myApp.main.entities;

import java.io.Serializable;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Entidade de cadeia de bytes -> 'Serializable'
 * @author User
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String phone;
	
	public User() {
	}

	public User(Long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
