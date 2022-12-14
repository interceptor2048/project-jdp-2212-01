
package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String name;


    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name="PRICE")
    private BigDecimal price;

    @JsonManagedReference
    @Column(name="CARTS")
    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<CartItem> carts = new HashSet<>();
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    public Product( String name, String description, BigDecimal price, Set<CartItem> carts, Group group) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.carts = carts;
        this.group = group;
    }

    public Product(long id, String name, String description, BigDecimal price, Group group) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.group = group;
    }
}

