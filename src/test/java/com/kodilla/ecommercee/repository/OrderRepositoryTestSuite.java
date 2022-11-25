package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.CartItem;
import com.kodilla.ecommercee.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderRepositoryTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testOrderRepositorySave() {
        //Given
        CartItem cartItem = new CartItem();
        Order order = new Order();
        order.getCartItems().add(cartItem);
        cartItem.setOrder(order);

        //When
        orderRepository.save(order);
        long orderId = order.getId();
        long cartItemId = cartItem.getId();

        //Then
        assertNotEquals(orderId, 0);
        assertNotEquals(cartItemId, 0);

        //Cleanup
        orderRepository.deleteById(orderId);
    }

    @Test
    void testOrderRepositoryFindById() {
        //Given
        Order order = new Order();
        orderRepository.save(order);
        long orderId = order.getId();

        //When
        Optional<Order> orderFoundById = orderRepository.findById(orderId);

        //Then
        try {
            assertTrue(orderFoundById.isPresent());
        } finally {
            //Cleanup
            orderRepository.deleteById(orderId);
        }
    }

    @Test
    void testOrderRepositoryDeleteById() {
        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        orderRepository.save(order1);
        orderRepository.save(order2);
        long order1Id = order1.getId();
        long order2Id = order2.getId();

        //When
        orderRepository.deleteById(order1Id);
        Optional<Order> order1FoundById = orderRepository.findById(order1Id);
        Optional<Order> order2FoundById = orderRepository.findById(order2Id);

        //Then
        try {
            assertFalse(order1FoundById.isPresent());
            assertTrue(order2FoundById.isPresent());
        } finally {
            //Cleanup
            orderRepository.deleteById(order2Id);
        }

    }


}
