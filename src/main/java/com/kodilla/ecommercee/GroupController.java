package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Void> addGroup(GroupDto groupDto) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{groupId}")
    public ResponseEntity<GroupDto> getGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(new GroupDto(1L, "Test name"));
    }

    @PutMapping(value = "{groupId}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long groupId) {
        Group group = new Group(new ArrayList<>(), 2);
        groupRepository.save(group);
        return ResponseEntity.ok(group);
    }
}
