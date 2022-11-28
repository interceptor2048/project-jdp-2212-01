package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.CartItem;
import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private User user;
    private LocalDateTime dateTime;
    private CartStatus cartStatus;
    private Set<CartItem> cartItems;
}

