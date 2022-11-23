package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long userId;
    private Optional<LocalDateTime> dateTime;
    private CartStatus cartStatus;
}