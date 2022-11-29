
package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.annotations.FetchMode.SELECT;


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
            fetch = FetchType.LAZY)
    @Fetch(value = SELECT)
    private Set<CartItem> carts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
}
