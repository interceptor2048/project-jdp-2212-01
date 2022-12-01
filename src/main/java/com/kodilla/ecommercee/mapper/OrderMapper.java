package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartItem;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    public Order mapToOrder (final OrderDto orderDto) {

        Order order = new Order();
        Set<Product> uniqueProducts = new HashSet<>(orderDto.getProductList());
        Set<CartItem> cartItems = new HashSet<>();

        for (Product product : uniqueProducts) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(orderDto.getProductList().stream()
                    .filter(p -> p.equals(product))
                    .count());
            cartItem.setUnitPrice(product.getPrice());
            cartItem.setOrder(order);
        }

        order.setId(orderDto.getId());
        order.setDateTime(orderDto.getDateTime());
        order.setCartStatus(orderDto.getCartStatus());
        order.setUser(orderDto.getUser());
        order.setCartItems(cartItems);
        return order;
    }

    public OrderDto mapToOrderDto (final Order order) {
        List<Product> productList = new ArrayList<>();
        for (CartItem cartItem : order.getCartItems()) {
            for (int i = 0; i < cartItem.getQuantity(); i++) {
                productList.add(cartItem.getProduct());
            }
        }
        return new OrderDto(
                order.getId(),
                order.getUser(),
                order.getDateTime(),
                order.getCartStatus(),
                productList
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
