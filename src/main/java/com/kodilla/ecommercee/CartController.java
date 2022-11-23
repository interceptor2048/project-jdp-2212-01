package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/v1/carts")
public class CartController {


    @PostMapping(value = "/emptyCart")
    public ResponseEntity<CartDto> createEmptyCart(){
        return ResponseEntity.ok(new CartDto(1, new ArrayList<>()));
    }

    @GetMapping(value = "/getEmptyCart/{cardId}")
    public ResponseEntity<CartDto> getEmptyCart(@PathVariable Long cardId){
        return ResponseEntity.ok(new CartDto(cardId, new ArrayList<>()));
    }

    @PostMapping(value = "/addProducts/{cardId}/{productId}")
    public ResponseEntity<OrderDto> addProduct(@PathVariable Long cardId, @PathVariable Long productId) {
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