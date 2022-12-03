package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime = LocalDateTime.now();

    @Column(name = "STATUS")
    private CartStatus cartStatus = CartStatus.CART;
    @JsonManagedReference
    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<CartItem> cartItems = new HashSet<>();

    public Order(User user, LocalDateTime dateTime, CartStatus cartStatus, Set<CartItem> cartItems) {
        this.user = user;
        this.dateTime = dateTime;
        this.cartStatus = cartStatus;
        this.cartItems = cartItems;
    }
}
