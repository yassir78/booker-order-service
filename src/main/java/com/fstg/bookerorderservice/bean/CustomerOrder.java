package com.fstg.bookerorderservice.bean;

import java.math.BigDecimal;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private String shipToAddress;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate shipToDate;
	private String sellerRef;
	private String buyerRef;
	private BigDecimal orderAmount;
	@ManyToOne
	private OrderStatus status;
	@OneToMany(mappedBy = "relatedCustomerOrder")
	private List<OrderItem> orderItems;
}
