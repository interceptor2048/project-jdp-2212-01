package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/v1/users")
public class UserController {

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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok((new UserDto(1L, "JohnyWick78", "Martin", "Smith", false, 141L)));
    }
}