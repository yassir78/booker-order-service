package com.fstg.bookerorderservice.infra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerOrderEntity {
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
	private OrderStatusEntity status;
	@OneToMany(mappedBy = "relatedCustomerOrder")
	private List<OrderItemEntity> orderItems;
}
