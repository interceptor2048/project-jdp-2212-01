package com.kodilla.ecommercee.cartTests;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class CartTestSuit {

    @Autowired
    private CartRepository cartRepository;

    @Test
    void testSaveCart() {
        //Given
        Order cart = new Order();

        //When
        cartRepository.save(cart);
        long id = cart.getId();
        Optional<Order> readOrder = cartRepository.findById(id);

        //Then
        assertTrue(readOrder.isPresent());

    }

    @Test
    void testCartDelete() {
        //Given
        Order cart = new Order();
        Order cart1 = new Order();

        //When
        cartRepository.save(cart);
        cartRepository.save(cart1);
        long id = cart.getId();
        long id1 = cart1.getId();
        cartRepository.deleteById(id1);
        Optional<Order> readOrder = cartRepository.findById(id);
        Optional<Order> readOrder1 = cartRepository.findById(id1);

        //Then
        assertTrue(readOrder.isPresent());
        assertFalse(readOrder1.isPresent());
    }

    @Test
    void testAddCartItems() {
        //Given
        Order cart = new Order();
        CartItem cartItem = new CartItem();
        cart.getCartItems().add(cartItem);

        //When
        cartRepository.save(cart);
        long id = cart.getId();
        int n = cart.getCartItems().size();

        //Then
        assertEquals(1, n);
    }

    @Test
    void testSetStatus() throws Exception {
        //Given
        Order cart = new Order();
        cartRepository.save(cart);

        //When
        long id = cart.getId();
        Order cartRepositoryById = cartRepository.findById(id).orElseThrow(Exception::new);
        cartRepositoryById.setCartStatus(CartStatus.ORDER);
        cartRepository.save(cartRepositoryById);
        CartStatus result = cartRepository.findById(id).get().getCartStatus();

        //Then
        assertEquals(CartStatus.ORDER, result);
    }
}
