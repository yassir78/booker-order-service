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
    
    
}