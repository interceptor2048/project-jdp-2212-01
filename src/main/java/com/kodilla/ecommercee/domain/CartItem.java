package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CART_ITEM")
public class CartItem {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ITEM_ID")
    private long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "UNITPRICE")
    private BigDecimal unitPrice;

    public CartItem(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
        this.unitPrice = product.getPrice();
    }
}
