package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

import java.util.Set;


@Data
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Long userId;
    private LocalDateTime dateTime;
    private CartStatus cartStatus;
    private Set<CartItemDto> cartItems;
}

