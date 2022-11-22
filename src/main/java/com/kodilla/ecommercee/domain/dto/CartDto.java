package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {
    private long id;
    private long userId;
    private List<CartItem> productsInCard;
}