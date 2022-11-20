package com.kodilla.ecommercee.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {
    private int id;
    private  String name;
    private String description;
    private int price;
    private String groupId;
}
