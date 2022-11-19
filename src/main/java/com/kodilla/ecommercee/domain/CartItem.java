package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class CartItem {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID")
    private long id;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "PRODUCTS_IN_THE_CART",
//            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")},
//            inverseJoinColumns ={@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
//    )
//    private List<Product> products = new ArrayList<>();

//    @OneToOne
//    @JoinColumn(name = "ORDER_ID")
//    private Order order;

}
