package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CartItem> products = new ArrayList<>();

    public Cart(User user) {
        this.user = user;
    }

    public void addProduct(Product product) {
        CartItem cartItem = new CartItem(this, product);
        products.add(cartItem);
        product.getCarts().add(cartItem);
    }

    public void removeProduct(Product product) {
        for (Iterator<CartItem> iterator = products.iterator();
             iterator.hasNext();) {
            CartItem cartItem = iterator.next();

            if(cartItem.getCart().equals(this) && cartItem.getProduct().equals(product)) {
                iterator.remove();
                cartItem.getProduct().getCarts().remove(cartItem);
                cartItem.setCart(null);
                cartItem.setProduct(null);
            }
        }
    }
}