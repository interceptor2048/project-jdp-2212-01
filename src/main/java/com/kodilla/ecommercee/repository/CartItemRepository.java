package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.CartItem;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findAllByOrder(Order cart);

    List<CartItem> findAllByOrderAndProduct(Order cart, Product product);

    CartItem findByOrderAndProduct(Order cart, Product product);

}
