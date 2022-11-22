package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
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

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElse(new Cart());
    }

    public void addProduct(Long cartId, Long productId) {
        Cart cart = getCart(cartId);
        Product product = productRepository.findById(productId).get();
        cart.addProduct(product);
    }

    public void deleteProduct(Long cartId, Long productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(Exception::new);
        Cart cart = cartRepository.findById(cartId).orElseThrow(Exception::new);
        cart.removeProduct(product);
    }
}
