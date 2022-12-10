package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return new User(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.getFirstName(),
                userDto.getLastName(),
                false,
                "",
                bCryptPasswordEncoder.encode(userDto.getPassword()),
                new ArrayList<>()
        );
    }
    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getIsBlocked(),
                user.getUserKey(),
}
