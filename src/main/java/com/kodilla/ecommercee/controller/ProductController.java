package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.ProductDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;

@RequestMapping("/v1/products")
@RestController
public class ProductController {

    private final ProductDbService productDbService;
    private final ProductMapper productMapper;
    @Autowired
    public ProductController(ProductDbService productDbService, ProductMapper productMapper) {
        this.productDbService = productDbService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity <List<ProductDto>> getProducts() {
        List<Product> products = productDbService.getAllProducts();
        return ResponseEntity.ok(productMapper.mapToProductDtoList(products));
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        try {
        return ResponseEntity.ok(productMapper.mapToProductDto(productDbService.getProduct(productId)));
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>(
         new ProductDto(1L,"There is no product with id equals to" + productId,
                 "",new BigDecimal(1),new HashSet<>(),new Group()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        productDbService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        //Product saveProduct = productDbService.saveProduct(product);
        productDbService.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToProductDto(product));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        productDbService.saveProduct(product);
        return ResponseEntity.ok().build();
    }
}
