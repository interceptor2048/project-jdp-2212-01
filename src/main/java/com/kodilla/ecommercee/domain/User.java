package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "USERKEY")
    private Long userKey;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "ACCOUNT_BLOCKED")
    private Boolean isBlocked;

    @OneToMany(targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> users = new ArrayList<>();

    public User(String username, String firstName, String lastName, Boolean isBlocked, Long userKey, List<Order> users) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBlocked = isBlocked;
        this.userKey = userKey;
        this.users = users;
    }
}
