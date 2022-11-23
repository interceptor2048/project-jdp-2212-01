package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    @Autowired
    private UserRepository userRepository;

    public Order mapToCart(final CartDto cartDto) {
        return new Order(cartDto.getId(),
                null,
                LocalDateTime.now(),
                CartStatus.CART,
                new ArrayList<>());
    }

    public CartDto mapToCartDto(final Order cart) {
        return new CartDto(cart.getId(),
                new ArrayList<>());
    }

    public List<CartDto> mapToCartDtoList(final List<Order> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
