package com.kodilla.ecommercee.productTest;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductEntityTestSuite {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void testProductRepositorySave() {
        //Given
        CartItem cartItem= new CartItem();
        Product product = new Product();
        product.getCarts().add(cartItem);
        cartItem.setProduct(product);

        //When
        productRepository.save(product);
        long id = product.getId();
        //Then
        assertNotEquals(0, id);

        //CleanUp
        productRepository.deleteById(id);
    }

    @Test
    void testProductFindAll() {
        //Given
        Product product = new Product();
        Product product1 = new Product();
        CartItem cartItem= new CartItem();
        Set<Product> cartsItems = new HashSet<>();
        productRepository.save(product);
        productRepository.save(product1);
        long product1Id = product.getId();
        long product2Id = product1.getId();
        //When
        List<Product> products = (List<Product>) productRepository.findAll();
        List<Long> iDs = products.stream()
                .map(Product::getId)
                .collect(Collectors.toList());

        //Then
        try {
            assertTrue(iDs.contains(product1Id) && iDs.contains(product1Id));
        } finally {
            //CleanUp
            productRepository.deleteById(product1Id);
            productRepository.deleteById(product2Id);
        }
    }

    @Test
    void testOrderRepositoryFindById() {
        //Given
        Product product = new Product();
        productRepository.save(product);
        long productId = product.getId();
        //When
        Optional<Product> productFoundById = productRepository.findById(productId);
        //Then
        assertTrue(productFoundById.isPresent());

        //Cleanup
        productRepository.deleteById(productId);

    }

    @Test
    void testProductDeleteById() {
        //Given
        Product product = new Product();
        productRepository.save(product);
        long productId = product.getId();

        //When
        productRepository.deleteById(productId);
        Optional<Product> productFoundById = productRepository.findById(productId);

        //Then
        assertFalse(productFoundById.isPresent());
    }

}
