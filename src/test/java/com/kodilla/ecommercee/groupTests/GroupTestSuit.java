package com.kodilla.ecommercee.groupTests;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class GroupTestSuit {

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void saveGroup() {
        //Given
        Group group = new Group();

        //When
        groupRepository.save(group);

        //Then
        long id = group.getId();
        Optional<Group> readGroup = groupRepository.findById(id);
        assertTrue(readGroup.isPresent());

        //CleanUp
        groupRepository.deleteById(id);

    }
}