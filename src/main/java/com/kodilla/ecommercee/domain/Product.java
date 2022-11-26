package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private int price;
    @Column(name="GROUPID")
    private String groupId;
    @OneToMany(
            targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CartItem> cartItems =new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
}
