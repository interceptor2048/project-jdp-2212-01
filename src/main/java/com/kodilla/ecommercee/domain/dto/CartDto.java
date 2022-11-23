package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {
    private long id;
    private long userId;
    private List<CartItemDto> productsInCard;
}
