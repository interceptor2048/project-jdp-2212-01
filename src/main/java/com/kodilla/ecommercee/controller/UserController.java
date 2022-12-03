package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.exception.UserDoesntExist;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.exception.UserWithGivenUserNameExist;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @GetMapping(value = "GetUsers")
    public List<UserDto> getUser() {
        return new ArrayList<>();
    }

    @GetMapping(value = "GenerateUserKey")
    public ResponseEntity<Long> generateUserKey(@RequestParam Long userId) {
        Long generatedKey = new Random().nextLong();
        return ResponseEntity.ok(userId + generatedKey);
    }

    @PutMapping(value = "BlockUser")
    public ResponseEntity<String> blockUser(@RequestParam Long userId, @RequestParam Boolean isBlocked) {
        isBlocked = true;
        return ResponseEntity.ok("This user is now blocked");
    }

    @PostMapping(value = "CreateUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws UserWithGivenUserNameExist {
        tokenService.saveUser(new User("username", "firstname", "lastname", false, 124432L, new ArrayList<>(), "password"));
        return ResponseEntity.ok((new UserDto(1L, "JohnyWick78", "Martin", "Smith", false, 141L, "Password")));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) throws UserNotFoundException, UserDoesntExist {
        return ResponseEntity.ok(tokenService.generateToken(username, password));
    }
}