package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @JoinColumn(name = "group_group_id")
    private Group group;
}
