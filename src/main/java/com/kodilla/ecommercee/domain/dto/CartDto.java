package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    private long id;
    private List<CartItem> products;
}
