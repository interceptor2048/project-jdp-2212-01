package com.kodilla.ecommercee.groupTests;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class GroupTestSuit {

    @Autowired
    private GroupRepository groupRepository;

    @Test
    void testGroupRepositoryFindById() {
        //Given
        Group group = new Group();
        groupRepository.save(group);
        long groupId = group.getId();
        //When
        Optional<Group> groupFoundById = groupRepository.findById(groupId);
        //Then
        assertTrue(groupFoundById.isPresent());

        //Cleanup
        groupRepository.deleteById(groupId);

    }

    @Test
    void testGroupRepositorySave() {
        //Given
        Product product = new Product();
        Group group = new Group();
        group.getProducts().add(product);
        product.setGroup(group);

        //When
        groupRepository.save(group);
        long id = group.getId();
        //Then
        assertNotEquals(0, id);

        //CleanUp
        groupRepository.deleteById(id);
    }

    @Test
    void testProductFindAll() {
        //Given
        Group group = new Group();
        Group group1 = new Group();
        Product product= new Product();
        Set<Group> products = new HashSet<>();
        groupRepository.save(group);
        groupRepository.save(group1);
        long group1Id = group.getId();
        long group2Id = group1.getId();
        //When
        List<Group> groups = (List<Group>) groupRepository.findAll();
        List<Long> iDs = groups.stream()
                .map(Group::getId)
                .collect(Collectors.toList());

        //Then
        try {
            assertTrue(iDs.contains(group1Id) && iDs.contains(group1Id));
        } finally {
            //CleanUp
            groupRepository.deleteById(group1Id);
            groupRepository.deleteById(group2Id);
        }
    }
}