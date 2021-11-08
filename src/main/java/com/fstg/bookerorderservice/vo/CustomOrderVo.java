package com.fstg.bookerorderservice.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomOrderVo {
	private Long id;
	private String ref;
	private String shipToAddress;
	private LocalDate orderDate;
	private LocalDate shipToDate;
	private String sellerRef;
	private String buyerRef;
	private BigDecimal orderAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getShipToAddress() {
		return shipToAddress;
	}

	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getShipToDate() {
		return shipToDate;
	}

	public void setShipToDate(LocalDate shipToDate) {
		this.shipToDate = shipToDate;
	}

	public String getSellerRef() {
		return sellerRef;
	}

	public void setSellerRef(String sellerRef) {
		this.sellerRef = sellerRef;
	}

	public String getBuyerRef() {
		return buyerRef;
	}

	public void setBuyerRef(String buyerRef) {
		this.buyerRef = buyerRef;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

}
