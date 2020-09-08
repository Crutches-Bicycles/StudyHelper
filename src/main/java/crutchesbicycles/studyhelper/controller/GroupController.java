package crutchesbicycles.studyhelper.controller;
import crutchesbicycles.studyhelper.domain.Groups;
import crutchesbicycles.studyhelper.exception.GroupExistsException;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.repos.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupRepository groupRepository;

    @GetMapping
    List<Groups> getGroups(){
        return groupRepository.findAll();
    }

    @GetMapping("{idGroup}")
    Groups getGroupById(@PathVariable Long idGroup){
        Optional<Groups> optionalGroup = groupRepository.findByIdGroup(idGroup);
        optionalGroup.orElseThrow(
                ()-> new GroupNotFoundException(idGroup.toString())
        );

        return optionalGroup.get();
    }

    @PutMapping("{idGroup}")
    ResponseEntity<?> updateGroupById(@PathVariable Long idGroup, @RequestParam String caption,
                                      @RequestParam String email){
        Optional<Groups> optionalGroup = groupRepository.findByIdGroup(idGroup);
        optionalGroup.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );
        if (groupRepository.findByEmailOrCaption(email, caption).isPresent()){
            throw new GroupExistsException(email, caption);
        }

        Groups tempGroup = optionalGroup.get();
        if (!tempGroup.getEmail().equals(email)){
            tempGroup.setEmail(email);
        }

        if (!tempGroup.getCaption().equals(caption)){
            tempGroup.setCaption(caption);
        }

        groupRepository.save(tempGroup);
        return new ResponseEntity<>("Group with id '" + idGroup.toString() + "' updated", HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> createGroup(@RequestParam String caption, @RequestParam String email){
        Groups tempGroup = new Groups(caption, email);
        if (groupRepository.findByEmailOrCaption(email, caption).isPresent()){
            throw new GroupNotFoundException(caption);
        }
        groupRepository.save(tempGroup);
        return new ResponseEntity<>("Group was created", HttpStatus.CREATED);
    }

    @DeleteMapping("{idGroup}")
    ResponseEntity<?> deleteGroup(@PathVariable Long idGroup){
        groupRepository.findByIdGroup(idGroup).orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        groupRepository.deleteById(idGroup);

        return new ResponseEntity<>("Group with id '" + idGroup + "' deleted", HttpStatus.OK);
    }

    @Autowired
    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
