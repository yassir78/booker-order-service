package com.fstg.bookerorderservice.application.dto;

import com.fstg.bookerorderservice.domain.pojo.OrderItem;
import com.fstg.bookerorderservice.infra.entity.OrderStatusEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
public class CustomerOrderDto {
    private Long id;
    private String ref;
    private String shipToAddress;
    private LocalDate orderDate;
    private LocalDate shipToDate;
    private String sellerRef;
    private String buyerRef;
    private BigDecimal orderAmount;
    private OrderStatusEntity status;
    private List<OrderItemDto> orderItemDtos;
}
