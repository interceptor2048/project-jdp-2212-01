package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartStatus;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/ecommercee/orders")
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return new OrderDto(1L, 1L, Optional.of(LocalDateTime.now()), CartStatus.ORDER);
    }

    @DeleteMapping
    public void deleteOrder(Long orderId) {

    }

    @PutMapping
    public OrderDto updateOrder(OrderDto orderDto) {
        return new OrderDto(1L, 1L, Optional.of(LocalDateTime.now()), CartStatus.ORDER);
    }

    @PostMapping
    public void createOrder(OrderDto orderDto) {

    }

}
