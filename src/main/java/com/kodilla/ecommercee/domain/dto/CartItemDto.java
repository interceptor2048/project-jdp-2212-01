package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDto {

    private long id;
    private long product_id;
    private long order_id;
    private long quantity;
    private BigDecimal unitPrice;
}
