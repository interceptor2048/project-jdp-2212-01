<<<<<<< HEAD
package com.kodilla.ecommercee.domain;public class CartItem {
=======
package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "UNITPRICE")
    private BigDecimal unitPrice;
>>>>>>> origin/master
}
