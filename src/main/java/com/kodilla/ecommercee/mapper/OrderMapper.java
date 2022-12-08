package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartItemMapper cartItemMapper;

    public Order mapToOrder (final OrderDto orderDto) throws UserNotFoundException {

        return new Order(
                orderDto.getId(),
                userRepository.findById(orderDto.getUserId()).orElseThrow(UserNotFoundException::new),
                orderDto.getDateTime(),
                CartStatus.ORDER,
                new HashSet<>()
        );
    }

    public OrderDto mapToOrderDto (final Order order) {

        return new OrderDto(
                order.getId(),
                order.getUser().getUserId(),
                order.getDateTime(),
                order.getCartStatus(),
                cartItemMapper.mapToCartItemDtoSet(order.getCartItems())
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(order -> {
                    try {
                        return mapToOrderDto(order);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
