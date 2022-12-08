package com.kodilla.ecommercee.userTest;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;
    @Test
    void testSaveUser() {
        //Given
        User user1 = new User();

        //When
        userRepository.save(user1);
        long userId1 = user1.getUserId();
        Optional<User> checkUser = userRepository.findById(userId1);

        //Then
        assertTrue(checkUser.isPresent());

        //Cleanup
        userRepository.deleteById(userId1);

    }

    @Test
    void testDeleteUser() {
        // Given
        User user1 = new User();
        User user2 = new User();
        //When
        userRepository.save(user1);
        userRepository.save(user2);
        long userId1 = user1.getUserId();
        long userId2 = user2.getUserId();
        //Then
        userRepository.deleteById(userId2);
        Optional<User> findUser1 = userRepository.findById(userId1);
        Optional<User> findUser2 = userRepository.findById(userId2);

        //Then
        try {
            assertTrue(findUser1.isPresent());
            assertFalse(findUser2.isPresent());
        } finally {
            //Cleanup
            userRepository.deleteById(userId1);
        }
    }

    @Test
    void testFindAllUsers() {
        // Given
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        long userId1 = user1.getUserId();
        long userId2 = user2.getUserId();
        long userId3 = user3.getUserId();
        List<User> users = (List<User>) userRepository.findAll();
        List<Long> userIds = users.stream()
                .map(User::getUserId)
                .collect(Collectors.toList());
        //Then
        try {
            assertEquals(userIds.size(), 3);
        } finally {
            //Cleanup
            userRepository.deleteById(userId1);
            userRepository.deleteById(userId2);
            userRepository.deleteById(userId3);
        }
    }

    @Test
    void testUserRepositoryFindById() {
        //Given
        User user = new User();
        userRepository.save(user);
        long userId = user.getUserId();
        //When
        Optional<User> userFoundById = userRepository.findById(userId);
        //Then
        try {
            assertTrue(userFoundById.isPresent());
        } finally {
            //Cleanup
            userRepository.deleteById(userId);
        }
    }

}
