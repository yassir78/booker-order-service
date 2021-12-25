package com.fstg.bookerorderservice.infra.dto;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto {
    private Long id;
    private String reference;
    private double amount;
    private String orderReference;

    public PaymentDto(String reference, double amount, String orderReference) {
        this.reference = reference;
        this.amount = amount;
        this.orderReference = orderReference;
    }
}