package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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

    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<CartItem> cartItems = new HashSet<>();
}
