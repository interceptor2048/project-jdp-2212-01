package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public Order saveCart(Order cart) {
        return cartRepository.save(cart);
    }

    public OrderDto createOrder(Long cartId, Long userId) throws Exception {
        Order order = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        return new OrderDto(order.getId(), user.getUserId(), LocalDateTime.now(), CartStatus.ORDER);
    }
}
