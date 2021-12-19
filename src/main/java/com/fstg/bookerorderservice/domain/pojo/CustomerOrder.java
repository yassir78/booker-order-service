package com.fstg.bookerorderservice.domain.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fstg.bookerorderservice.application.dto.OrderStatusDto;
import com.fstg.bookerorderservice.infra.entity.OrderItemEntity;
import com.fstg.bookerorderservice.infra.entity.OrderStatusEntity;
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
public class CustomerOrder {
    private Long id;
    private String ref;
    private String shipToAddress;
    private LocalDate orderDate;
    private LocalDate shipToDate;
    private String sellerRef;
    private String buyerRef;
    private BigDecimal orderAmount;
    private OrderStatus status;
    private List<OrderItem> orderItems;

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", shipToAddress='" + shipToAddress + '\'' +
                ", orderDate=" + orderDate +
                ", shipToDate=" + shipToDate +
                ", sellerRef='" + sellerRef + '\'' +
                ", buyerRef='" + buyerRef + '\'' +
                ", orderAmount=" + orderAmount +
                ", status=" + status +
                ", orderItems=" + orderItems +
                '}';
    }
}
