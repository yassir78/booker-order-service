package com.fstg.bookerorderservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class OrderItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer quantity;
	private BigDecimal total;
	private Long productRef;
	@ManyToOne
	@JsonIgnore
	private CustomerOrderEntity relatedCustomerOrder;

	public Long getId() {
		return id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public Long getProductRef() {
		return productRef;
	}

	public CustomerOrderEntity getRelatedCustomerOrder() {
		if(relatedCustomerOrder == null) {
			relatedCustomerOrder = new CustomerOrderEntity();
		}
		return relatedCustomerOrder;
	}
}
