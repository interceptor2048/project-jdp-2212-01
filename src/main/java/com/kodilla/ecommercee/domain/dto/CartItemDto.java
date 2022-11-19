package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartItemDto {
    private long id;
    private long productId;
    private long quantity;
    private BigDecimal unitPrice;
    private long orderId;
}