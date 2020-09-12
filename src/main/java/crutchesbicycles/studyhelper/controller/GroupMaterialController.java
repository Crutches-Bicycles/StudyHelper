package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.GroupMaterial;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.repos.GroupMaterialRepository;
import crutchesbicycles.studyhelper.repos.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupMaterialController {
    private final GroupRepository groupRepository;
    private final GroupMaterialRepository groupMaterialRepository;

    @GetMapping("/{idGroup}/materials")
    List<GroupMaterial> getGroupMaterial(@PathVariable Long idGroup){
        // проверка существует ли группа
        checkGroup(idGroup);
        return groupMaterialRepository.findAllByGroupIdGroup(idGroup);
    }

    void checkGroup(Long idGroup){
        groupRepository.findByIdGroup(idGroup).orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );
    }

    @Autowired
    public GroupMaterialController(GroupRepository groupRepository, GroupMaterialRepository groupMaterialRepository) {
        this.groupRepository = groupRepository;
        this.groupMaterialRepository = groupMaterialRepository;
    }
}
