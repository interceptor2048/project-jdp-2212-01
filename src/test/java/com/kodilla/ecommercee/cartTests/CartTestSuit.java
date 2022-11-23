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
    void testCreateOrder() {
        //Given
        User user = new User();
        Order cart = new Order();

        //When
        cartRepository.save(cart);
        long id = cart.getId();
        Optional<Order> readOrder = cartRepository.findById(id);

        //Then
        assertTrue(readOrder.isPresent());

    }

    @Test
    void testAddProducts() {
        //Given
        User user = new User();
        Group group = new Group();
        Order cart = new Order();
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
    void testOrderDelete() {
        //Given
        User user = new User();
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
    void testUpdateProducts() {
        //Given
        User user = new User();
        Order cart = new Order();
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
