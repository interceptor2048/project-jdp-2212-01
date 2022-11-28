package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public Order mapToOrder (final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getUser(),
                orderDto.getDateTime(),
                orderDto.getCartStatus(),
                orderDto.getCartItems()
        );
    }

    public OrderDto mapToOrderDto (final Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getDateTime(),
                order.getCartStatus(),
                order.getCartItems()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
