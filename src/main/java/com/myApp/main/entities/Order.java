package com.myApp.main.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = 
			"yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	@ManyToOne //transforma em chave estrangeira
	@JoinColumn(name = "client_id")
	private User client;
	
	public Order(Long id, Instant momento, User client) {
		super();
		this.id = id;
		this.momento = momento;
		this.client = client;
	}

}
