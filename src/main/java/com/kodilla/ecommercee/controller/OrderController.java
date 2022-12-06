package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.exception.IllegalIdForOrderCreateException;
import com.kodilla.ecommercee.exception.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private final OrderDbService dbService;
    private final OrderMapper orderMapper;

    @GetMapping
    public List<OrderDto> getOrders() {
        List<Order> allOrdersList = dbService.getAllOrders();
        return orderMapper.mapToOrderDtoList(allOrdersList);
    }

    @GetMapping(value = "{orderId}")

    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) throws Exception {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(dbService.getOrder(orderId)));
    }

    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        dbService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) throws Exception {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = dbService.saveOrder(order);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(savedOrder));

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) throws IllegalIdForOrderCreateException {
        if (orderDto.getId() > 0) {
            throw new IllegalIdForOrderCreateException();
        }
        Order order = orderMapper.mapToOrder(orderDto);
        dbService.saveOrder(order);
        return ResponseEntity.ok().build();
    }
}