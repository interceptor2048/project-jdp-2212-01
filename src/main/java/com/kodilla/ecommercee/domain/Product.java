
package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

}
