package com.kodilla.ecommercee.cartTests;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class CartTestSuit {

    @Autowired
    private CartRepository cartRepository;

    @Test
    void testCreateCart() {
        //Given
        User user = new User();
        Cart cart = new Cart(user);

        //When
        cartRepository.save(cart);
        long id = cart.getId();
        Optional<Cart> readCart = cartRepository.findById(id);

        //Then
        assertTrue(readCart.isPresent());

    }

    @Test
    void testAddProducts() {
        //Given
        User user = new User();
        Group group = new Group();
        Cart cart = new Cart(user);
        Product product = new Product(group, "name", "description", new BigDecimal(5));
        Product product1 = new Product(group, "name1", "description1", new BigDecimal(6));
        Product product2 = new Product(group, "name2", "description2", new BigDecimal(3));
        Product product3 = new Product(group, "name3", "description3", new BigDecimal(4));
        Product product4 = new Product(group, "name4", "description4", new BigDecimal(2));
        cart.addProduct(product);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);

        //When
        int result = cart.getProducts().size();
        for (CartItem cartProduct : cart.getProducts()) {
            System.out.println(cartProduct.getProduct());
        }

        //Then
        assertEquals(5, result);
    }

    @Test
    void testCartDelete() {
        //Given
        User user = new User();
        Cart cart = new Cart(user);
        Cart cart1 = new Cart(user);

        //When
        cartRepository.save(cart);
        cartRepository.save(cart1);
        long id = cart.getId();
        long id1 = cart1.getId();
        cartRepository.deleteById(id1);
        Optional<Cart> readCart = cartRepository.findById(id);
        Optional<Cart> readCart1 = cartRepository.findById(id1);

        //Then
        assertTrue(readCart.isPresent());
        assertFalse(readCart1.isPresent());
    }

    @Test
    void testUpdateProducts() {
        //Given
        User user = new User();
        Cart cart = new Cart(user);
        Group group = new Group();
        Product product = new Product(group, "name", "description", new BigDecimal(5));
        Product product1 = new Product(group, "name1", "description1", new BigDecimal(6));
        Product product2 = new Product(group, "name2", "description2", new BigDecimal(3));
        Product product3 = new Product(group, "name3", "description3", new BigDecimal(4));
        Product product4 = new Product(group, "name4", "description4", new BigDecimal(2));

        //When
        cartRepository.save(cart);
        long id = cart.getId();
        cartRepository.findById(id).get().addProduct(product);
        cartRepository.findById(id).get().addProduct(product1);
        cartRepository.findById(id).get().addProduct(product2);
        cartRepository.findById(id).get().addProduct(product3);
        cartRepository.findById(id).get().addProduct(product4);
        int n = cartRepository.findById(id).get().getProducts().size();

        //Then
        assertEquals(5, n);
    }
}
