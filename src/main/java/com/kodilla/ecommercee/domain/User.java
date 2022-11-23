package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private Long userId;

    private String username;

    private String firstName;

    private String lastName;

    private Boolean isBlocked;

    private Long userKey;

}

