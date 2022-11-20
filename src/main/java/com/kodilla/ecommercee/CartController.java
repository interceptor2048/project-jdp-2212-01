package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/v1/carts")
public class CartController {


    @PostMapping(value = "/emptyCart")
    public ResponseEntity<CartDto> createEmptyCart(){
        return ResponseEntity.ok(new CartDto(0,0,new ArrayList<>()));
    }

    @GetMapping(value = "/getEmptyCart/{cardId}")
    public ResponseEntity<CartDto> getEmptyCart(@PathVariable Long cardId){
        return ResponseEntity.ok(new CartDto(cardId, 0, new ArrayList<>()));
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
