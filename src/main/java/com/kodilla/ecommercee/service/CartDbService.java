package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartDbService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public Order saveCart(Order cart) {
        return cartRepository.save(cart);
    }

    public Order getCart(Long cartId) {
        return cartRepository.findById(cartId).orElse(new Order());
    }

    public void addProduct(Long cartId, Long productId) {
        Order cart = getCart(cartId);
        Product product = productRepository.findById(productId).get();
        cart.addProduct(product);
    }

    public void deleteProduct(Long cartId, Long productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(Exception::new);
        Order cart = cartRepository.findById(cartId).orElseThrow(Exception::new);
        cart.removeProduct(product);
    }
}
