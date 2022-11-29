package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private User user;
    private LocalDateTime dateTime;
    private CartStatus cartStatus;
    private List<Product> productList;
}

