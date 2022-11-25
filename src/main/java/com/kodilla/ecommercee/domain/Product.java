<<<<<<< HEAD
package com.kodilla.ecommercee.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Product {
    private int id;
    private  String name;
    private String description;
    private int price;
    private String groupId;
=======
package com.kodilla.ecommercee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID")
    private long id;
>>>>>>> origin/master
}
