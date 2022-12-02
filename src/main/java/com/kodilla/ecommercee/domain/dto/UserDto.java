package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class UserDto {

    private Long userId;

    private String username;

    private String firstName;

    private String lastName;

    private Boolean isBlocked;

    private Long userKey;
}