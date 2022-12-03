package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"GROUPS\"")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID")
    private long id;

    @Column(name = "name")
    private String groupName;

    @OneToMany(targetEntity = Product.class, mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> product = new ArrayList<>();

    public Group(String groupName, List<Product> product) {
        this.groupName = groupName;
        this.product = product;
    }
}
