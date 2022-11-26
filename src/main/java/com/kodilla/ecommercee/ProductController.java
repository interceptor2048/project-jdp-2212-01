package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;

@RequestMapping("/v1/products")
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    GroupRepository groupRepository;

    @GetMapping
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1, "kurtka zimowa", "Pellentesque tempus...", 100, "1");
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{productId}")
    public ProductDto updateProduct(@PathVariable Long productId) {
        return new ProductDto(1, "kurtka MODIFY", "Pellentesque tempus...", 100, "1");
    }

    @PostMapping
    public ResponseEntity<Product> createProduct() {
        Product product = new Product(1, new HashSet<>(), null, "kurtka MODIFY", "Pellentesque tempus...", new BigDecimal(10));
        return ResponseEntity.ok(productRepository.save(product));
    }
}