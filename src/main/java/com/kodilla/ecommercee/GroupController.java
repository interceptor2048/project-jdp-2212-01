package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {

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
        return ResponseEntity.ok(new GroupDto(1L,"Test name"));
    }

    @PutMapping(value = "{groupId}")
    public GroupDto updateGroup(@PathVariable Long groupId) {
        return new GroupDto(1L, "Edited test name");
    }
}
