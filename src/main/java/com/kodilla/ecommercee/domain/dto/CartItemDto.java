package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartItemDto {
    private long id;
    private long product_id;
    private long order_id;
    private String productName;
    private BigDecimal unitPrice;
    private long quantity;
    private BigDecimal totalPrice;
}
