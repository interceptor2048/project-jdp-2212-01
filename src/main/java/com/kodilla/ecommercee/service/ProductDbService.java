package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDbService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return (List<Product>) repository.findAll();
    }
    /*
    public Optional<Product> getProduct(final Long id) {
        return repository.findById(id);

    }

     */

    public Product saveProduct(final Product product) {
        return repository.save(product);
    }

    public Product getProduct(final Long productId) throws ProductNotFoundException {
        return repository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }



    public void deleteProduct(final Long productId) throws ProductNotFoundException {
        repository.deleteById(productId);

    }
}