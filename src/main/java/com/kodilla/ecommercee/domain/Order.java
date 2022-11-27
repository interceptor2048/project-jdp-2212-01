package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column (name = "ID")
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
    private List<CartItem> cartItems = new ArrayList<>();

}
