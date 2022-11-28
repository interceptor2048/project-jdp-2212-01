package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
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
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "UNIT_PRICE")
    private BigDecimal unitPrice;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    public CartItem(Order order, Product product, String productName, BigDecimal unitPrice, long quantity, BigDecimal totalPrice) {
        this.unitPrice = unitPrice;
        this.productName = productName;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
