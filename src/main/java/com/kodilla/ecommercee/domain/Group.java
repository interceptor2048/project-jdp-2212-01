package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "NAME")
    private String groupName;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();
    
    public Group( String groupName, List<Product> products) {
        this.products = products;
        this.groupName = groupName;
    }
}
