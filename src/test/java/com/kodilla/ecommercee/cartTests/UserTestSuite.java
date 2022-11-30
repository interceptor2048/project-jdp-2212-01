package com.kodilla.ecommercee.cartTests;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        //Given
        User user = new User();

        //When
        userRepository.save(user);
        long userId = user.getUserId();
        Optional<User> checkUser = userRepository.findById(userId);

        //Then
        assertTrue(checkUser.isPresent());

    }

    @Test
    void testSaveUser2() {
        // Given

        //When

        //Then
    }
}
