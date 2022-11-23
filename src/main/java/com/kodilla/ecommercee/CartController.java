package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.CartItemDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/v1/carts")
public class CartController {

    @Autowired
    private CartDbService cartDbService;
    @Autowired
    private CartItemDbService cartItemDbService;
    @Autowired
    private CartMapper cartMapper;


    @PostMapping(value = "/emptyCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDto> createEmptyCart(@RequestBody CartDto cartDto){
        Order cart = cartMapper.mapToCart(cartDto);
        cartDbService.saveCart(cart);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getEmptyCart/{cardId}")
    public ResponseEntity<CartDto> getEmptyCart(@PathVariable Long cardId){
        return ResponseEntity.ok(new CartDto(cardId, new ArrayList<>()));
    }

    @PostMapping(value = "/addProducts/{cardId}/{productId}")
    public ResponseEntity<CartDto> addProduct(@PathVariable Long cardId, @PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{cardId}/{productId}")
    public ResponseEntity<Void> deleteProductFromCard(@PathVariable Long cardId, @PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }
    @PostMapping(value = "createOrder")
    public ResponseEntity<Void> createOrderFromCart() {
        return ResponseEntity.ok().build();
    }
}