package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.kodilla.ecommercee.domain.Product;
import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {

    private long id;
    private List<Product> products;
}
