package com.fstg.bookerorderservice.application.dto;

import com.fstg.bookerorderservice.domain.pojo.CustomerOrder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long id;
    private Integer quantity;
    private BigDecimal total;
    private Long productRef;
    private CustomerOrderDto relatedCustomerOrderDto;
}
