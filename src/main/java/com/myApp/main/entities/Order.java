package com.myApp.main.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myApp.main.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_order")
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
	@Getter
	@Setter
	private Instant momento;
	
	@ManyToOne //transforma em chave estrangeira
	@JoinColumn(name = "client_id")
	@Getter
	@Setter
	private User client;
	@Getter
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	@Getter
	@Setter
	@OneToOne( //mapeia com o mesmo ID
			mappedBy = "order",
			cascade = CascadeType.ALL)
	private Payments pagamento;
	
	private Integer status;

	public Order( Instant momento,  OrderStatus status, User client) {
		super();
		this.momento = momento;
		this.client = client;
		this.setStatus(status);
	}

	public OrderStatus getStatus() {
		return OrderStatus.valueOf(status);
	}

	public void setStatus(OrderStatus orderstatus) {
		if (orderstatus != null) {
			this.status = orderstatus.getCode();
		}
	}
	
	public BigDecimal getTotal() {
		BigDecimal sum = BigDecimal.ZERO;
		for (OrderItem x : items) {
			sum = sum.add(x.subTotal());
		}
		return sum;
	}

}
