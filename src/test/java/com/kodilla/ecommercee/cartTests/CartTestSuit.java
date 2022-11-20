package com.kodilla.ecommercee.cartTests;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CartTestSuit {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByIdTest() {
        //Given
        User user = new User();
        userRepository.save(user);
        Cart cart = new Cart(user, new ArrayList<>());

        //When
        cartRepository.save(cart);
        long id = cart.getId();
        long userId = user.getId();
        Optional<Cart> readCart = cartRepository.findById(id);

        //Then
        assertTrue(readCart.isPresent());

        //Clen up
        cartRepository.deleteById(id);
        userRepository.deleteById(userId);

    }


}
