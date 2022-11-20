package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartDto {
    private long id;
    private long productId;
    private long quantity;
    private BigDecimal unitPrice;
    private long orderId;
}
