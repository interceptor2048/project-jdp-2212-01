package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/v1/products")
@RestController
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return new ProductDto(1,"kurtka zimowa","Pellentesque tempus...",100,"1");
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{productId}")
    public ProductDto updateProduct(@PathVariable Long productId) {
        return new ProductDto(1,"kurtka MODIFY","Pellentesque tempus...",100,"1");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct() {
        return ResponseEntity.ok().build();
    }
}
