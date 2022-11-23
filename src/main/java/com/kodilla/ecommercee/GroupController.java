package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {

    @GetMapping
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @PostMapping
    public void addGroup(GroupDto groupDto) {

    }

    @GetMapping(value = "{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) {
        return new GroupDto(1L,"Test name");
    }

    @PutMapping(value = "{groupId}")
    public GroupDto updateGroup(@PathVariable Long groupId) {
        return new GroupDto(1L, "Edited test name");
    }
}
