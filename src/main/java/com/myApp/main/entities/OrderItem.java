package com.myApp.main.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myApp.main.entities.pk.OrderItemPrimaryKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {

	@EmbeddedId
	@EqualsAndHashCode.Include
	private OrderItemPrimaryKey id = new OrderItemPrimaryKey();
	@Getter
	@Setter
	private Integer quantity;
	@Getter
	@Setter
	private BigDecimal preco;
	
	public OrderItem(Order order, Product product, Integer quantity, BigDecimal preco) {
		super();
		this.quantity = quantity;
		this.preco = preco;
		this.id.setOrder(order);
		this.id.setProduct(product);
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order o) {
		this.id.setOrder(o);
	}
	
	//@JsonIgnore
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product p) {
		this.id.setProduct(p);
	}
}
