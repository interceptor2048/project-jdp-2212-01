package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartItem;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartItemRepository;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartItemDbService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public List<CartItem> getProductsList(Long cartId) throws Exception {
        Cart cart = cartRepository.findById(cartId).orElseThrow(Exception::new);
        return cartItemRepository.findAllByCart(cart);
    }

    public CartItem addProduct(Long cardId, Long productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(Exception::new);
        Cart cart = cartRepository.findById(cardId).orElseThrow(Exception::new);

        CartItem cartItem = new CartItem(cart, product);
        return cartItemRepository.save(cartItem);
    }
}
