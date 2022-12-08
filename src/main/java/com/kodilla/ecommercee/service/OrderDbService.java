package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDbService {

    private final OrderRepository repository;

    public Order saveOrder(final Order order) {
        return repository.save(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll().stream()
                .filter(o -> o.getCartStatus().equals(CartStatus.ORDER))
                .collect(Collectors.toList());
    }

    public Order getOrder(final Long orderId) throws OrderNotFoundException {
        return repository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    public void deleteOrder (final Long orderId) throws OrderNotFoundException {
        if (repository.existsById(orderId)) {
            repository.deleteById(orderId);
        } else throw new OrderNotFoundException();
    }

}
