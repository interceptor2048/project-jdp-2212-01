package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return new OrderDto(1L, 1L, LocalDateTime.now(), CartStatus.ORDER);
    }

    @DeleteMapping
    public void deleteOrder(Long orderId) {

    }

    @PutMapping(value = "{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
        return new OrderDto(1L, 1L, LocalDateTime.now(), CartStatus.ORDER);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().build();
    }

}