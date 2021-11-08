package com.fstg.bookerorderservice.vo;

import java.math.BigDecimal;

public class OrderItemVo {

	private Long id;
	private Integer quantity;
	private BigDecimal total;
	private Long productRef;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Long getProductRef() {
		return productRef;
	}

	public void setProductRef(Long productRef) {
		this.productRef = productRef;
	}

}
