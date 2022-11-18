package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.CartItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/carts")
public class CartController {

    CartItemDto cartItemDto = new CartItemDto(0L, 0L, 0L, null, 0);

    @PostMapping(value = "/emptyCart")
    public ResponseEntity<CartItemDto> createEmptyCart(){
        return ResponseEntity.ok(cartItemDto);
    }

    @GetMapping(value = "/getEmptyCart")
    public ResponseEntity<CartItemDto> getEmptyCart(){
        return ResponseEntity.ok(cartItemDto);
    }

    @PostMapping(value = "/addProducts/{cardId}/{productId}")
    public ResponseEntity<CartItemDto> addProduct(@PathVariable Long cardId, @PathVariable Long productId) {
        return ResponseEntity.ok(new CartItemDto(cardId, productId, 0L, null, 0l));
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
