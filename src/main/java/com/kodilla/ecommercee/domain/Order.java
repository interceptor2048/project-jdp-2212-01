package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @NotNull
    @Column (name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "DATE_TIME")
    private LocalDateTime dateTime = LocalDateTime.now();

    @Column(name = "STATUS")
    private CartStatus cartStatus = CartStatus.CART;

    @OneToMany(targetEntity = CartItem.class,
            mappedBy = "order",
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