package com.kodilla.ecommercee.domain;

import lombok.Data;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "ACCOUNT_BLOCKED")
    private Boolean isBlocked;

    @Column(name = "USERKEY")
    private Long userKey;

    @OneToMany(targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
}
