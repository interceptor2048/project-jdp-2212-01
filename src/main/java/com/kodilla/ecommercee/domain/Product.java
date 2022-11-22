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
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID")
    private long id;

    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CartItem> carts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String desription;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Product(Group group, String name, String desription, BigDecimal price) {
        this.group = group;
        this.name = name;
        this.desription = desription;
        this.price = price;
    }
}
