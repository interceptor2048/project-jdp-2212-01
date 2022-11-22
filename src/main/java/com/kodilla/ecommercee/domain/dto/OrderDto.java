package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Long userId;
    private Optional<LocalDateTime> dateTime;
    private CartStatus cartStatus;
}
