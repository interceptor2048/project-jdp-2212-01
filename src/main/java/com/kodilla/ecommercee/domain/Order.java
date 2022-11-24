package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public class Order {

    private Long id;
    private Long userId;
    private Optional<LocalDateTime> dateTime;
    private CartStatus cartStatus;
}