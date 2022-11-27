
package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.annotations.FetchMode.SELECT;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter

@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID")
    private long id;
    @Column(name="NAME")
    private  String name;

    @Column(name="PRICE")
    private BigDecimal price;
    @Column(name="GROUPID")
    private String groupId;
    @OneToMany(
            targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CartItem> cartItems =new ArrayList<>();

    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @Fetch(value = SELECT)
    private Set<CartItem> carts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;



    @Column(name = "DESCRIPTION")
    private String description;


    public Product(long id, Group group, String name, String description, BigDecimal price) {
        this.id = id;
        this.group = group;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
