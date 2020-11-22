package crutchesbicycles.studyhelper.controller;
import crutchesbicycles.studyhelper.domain.Group;
import crutchesbicycles.studyhelper.domain.GroupTeacher;
import crutchesbicycles.studyhelper.exception.GroupExistsException;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.repos.GroupRepository;
import crutchesbicycles.studyhelper.repos.GroupTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupRepository groupRepository;
    private final GroupTeacherRepository groupTeacherRepository;

    /**
     * Получить список групп \n
     * <b>Путь: /api/groups</b> \n
     * Тип запроса: GET
     * @return Json c группами
     */
    @GetMapping
    List<Group> getGroups(){
        return groupRepository.findAll();
    }

    /**
     * Получить группу по id \n
     * <b>Путь: /api/groups/{idGroup}</b> \n
     * Тип запроса: GET
     * @param idGroup (URL шаблон) -- id группы
     * @return Json c данными группы, также может выдавать исключение GroupNotFoundException
     * @throws GroupNotFoundException
     */
    @GetMapping("{idGroup}")
    Group getGroupById(@PathVariable Long idGroup){
        Optional<Group> optionalGroup = groupRepository.findByIdGroup(idGroup);
        optionalGroup.orElseThrow(
                ()-> new GroupNotFoundException(idGroup.toString())
        );

        return optionalGroup.get();
    }

    /**
     * Обновить группу по id \n
     * <b>Путь: /api/groups/{idGroup}</b> \n
     * Тип запроса: PUT
     * @param idGroup (URL шаблон) -- id группы
     * @param caption (form-data) -- имя группы
     * @param email (form-data) -- почта группы
     * @return статус OK в случае удачного обновления, также может выдавать исключение GroupNotFoundException, GroupExistsException
     * @throws GroupNotFoundException
     * @throws GroupExistsException
     */
    @PutMapping("{idGroup}")
    @PreAuthorize("hasAnyRole({'USER', 'ADMIN'})")
    ResponseEntity<?> updateGroupById(@PathVariable Long idGroup, @RequestParam String caption,
                                      @RequestParam String email){
        Optional<Group> optionalGroup = groupRepository.findByIdGroup(idGroup);
        optionalGroup.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        List<Group> existGroup = groupRepository.findByEmailOrCaption(email, caption);
        if (existGroup.size() > 0){
            if (existGroup.get(0).getIdGroup() != idGroup) {
                throw new GroupExistsException(email, caption);
            }
        }

        Group tempGroup = optionalGroup.get();
        if (!tempGroup.getEmail().equals(email)){
            tempGroup.setEmail(email);
        }

        if (!tempGroup.getCaption().equals(caption)){
            tempGroup.setCaption(caption);
        }

        groupRepository.save(tempGroup);
        return new ResponseEntity<>("Group with id '" + idGroup.toString() + "' updated", HttpStatus.OK);
    }

    /**
     * Создать группу \n
     * <b>Путь: /api/groups/{idGroup}</b> \n
     * Тип запроса: POST
     * @param caption (form-data) -- имя группы
     * @param email (form-data) -- почта группы
     * @return в случае удачного добавления HTTP Status 201, также можеть выдавать исключение GroupExistsException
     * @throws GroupExistsException
     */
    @PostMapping
    ResponseEntity<?> createGroup(@RequestParam String caption, @RequestParam String email){
        if (groupRepository.findByEmailOrCaption(email, caption).size() > 0){
            throw new GroupExistsException(email, caption);
        }
        Group tempGroup = new Group(caption, email);
        groupRepository.save(tempGroup);
        return new ResponseEntity<>("Group was created", HttpStatus.CREATED);
    }

    /**
     * Удалить группу \n
     * <b>Путь: /api/groups/{idGroup}</b> \n
     * Тип запроса: DELETE
     * @param idGroup (URL-шаблон) -- id группы
     * @return в случае удачного добавления HTTP Status 200, также можеть выдавать исключение GroupNotFoundException
     * @throws GroupNotFoundException
     */
    @DeleteMapping("{idGroup}")

    ResponseEntity<?> deleteGroup(@PathVariable Long idGroup){
        groupRepository.findByIdGroup(idGroup).orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        groupRepository.deleteById(idGroup);

        return new ResponseEntity<>("Group with id '" + idGroup + "' deleted", HttpStatus.OK);
    }

    /**
     * Получить список преподавателей группу \n
     * <b>Путь: /api/groups/{idGroup}/teachers</b> \n
     * Тип запроса: GET
     * @param idGroup (URL-шаблон) -- id группы
     * @return сущность GroupTeacher в JSON, в случае ошибки выдает исключение
     * @throws GroupNotFoundException
     */
    // TODO: 04.10.2020 проверить создается ли сущность GroupTeacher вместе с Group
    @GetMapping("/{idGroup}/teachers")
    GroupTeacher getTeacherGroup(@PathVariable Long idGroup){
        Optional<GroupTeacher> optionalGroupTeacher = this.groupTeacherRepository.findByGroupIdGroup(idGroup);
        optionalGroupTeacher.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        return optionalGroupTeacher.get();
    }

    @Autowired
    public GroupController(GroupRepository groupRepository, GroupTeacherRepository groupTeacherRepository) {
        this.groupRepository = groupRepository;
        this.groupTeacherRepository = groupTeacherRepository;
    }
}
