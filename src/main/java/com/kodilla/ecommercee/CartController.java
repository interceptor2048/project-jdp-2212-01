package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.CartItemDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/carts")
public class CartController {

    @Autowired
    private CartDbService cartDbService;
    @Autowired
    private CartItemDbService cartItemDbService;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/emptyCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDto> createEmptyCart(@RequestBody CartDto cartDto) {
        Order cart = cartMapper.mapToCart(cartDto);
        cartDbService.saveCart(cart);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getCart/{cardId}")
    public ResponseEntity<List<Product>> getEmptyCart(@PathVariable Long cardId) throws Exception {
        List<CartItem> products = cartItemDbService.getProductsList(cardId);
        return ResponseEntity.ok(cartMapper.mapToProductList(products));
    }

    @PutMapping(value = "/addProducts/{cardId}/{productId}")
    public ResponseEntity<Product> addProduct(@PathVariable Long cardId, @PathVariable Long productId) throws Exception {
        CartItem cartItem = cartItemDbService.addProduct(cardId, productId);
        return ResponseEntity.ok(cartMapper.mapCartItemToProduct(cartItem));
    }

    @DeleteMapping(value = "{cardId}/{productId}")
    public ResponseEntity<Void> deleteProductFromCard(@PathVariable Long cardId, @PathVariable Long productId) throws Exception {
        cartItemDbService.removeProduct(cardId, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "createOrder/{cardId}/{userId}")
    public ResponseEntity<OrderDto> createOrderFromCart(@PathVariable Long cardId, @PathVariable Long userId) throws Exception {
        Order order = cartRepository.findById(cardId).orElseThrow(Exception::new);
        User user = userRepository.findById(userId).orElseThrow(Exception::new);

        OrderDto toReturn = new OrderDto(order.getId(), user.getId(), Optional.ofNullable(order.getDateTime()), CartStatus.ORDER);

        return ResponseEntity.ok().build();
    }
}