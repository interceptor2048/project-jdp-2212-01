package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.CartItem;
import com.kodilla.ecommercee.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
}
