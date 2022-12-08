package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;

import java.util.ArrayList;

public class UserMapper {

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getIsBlocked(),
                user.getUserKey(),
                user.getPassword());
    }

}
