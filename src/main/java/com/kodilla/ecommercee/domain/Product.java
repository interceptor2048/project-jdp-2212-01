
package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import javax.persistence.*;

import lombok.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID")
    private long id;

    @Column(name="NAME")
    private  String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name="PRICE")
    private BigDecimal price;

    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<CartItem> carts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public Product(String name, String description, BigDecimal price, Set<CartItem> carts, Group group) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.carts = carts;
        this.group = group;
    }
}
