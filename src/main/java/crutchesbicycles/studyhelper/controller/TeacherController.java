package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.*;
import crutchesbicycles.studyhelper.exception.*;
import crutchesbicycles.studyhelper.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;
    private final TeacherSubjectRepository teacherSubjectRepository;
    private final SubjectRepository subjectRepository;
    private final GroupTeacherRepository groupTeacherRepository;
    private final GroupRepository groupRepository;

    /**
     * Получить список всех преподавателей\n
     * <b>Путь: /api/teachers</b> \n
     * Тип запроса: GET
     * @return Список всех преподавателей
     */
    @GetMapping
    List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    /**
     * Получить преподавателя по id \n
     * <b>Путь: /api/teachers/{idTeachers}</b> \n
     * Тип запроса: GET
     * @param idTeacher (URL-шаблон) -- id преподавателя
     * @return сущность преподавателя,
     * если отсутствует с данным id может выкинуть исключение TeacherNotFoundException
     * @throws TeacherNotFoundException
     */
    @GetMapping("/{idTeacher}")
    Teacher getTeacherById(@PathVariable Long idTeacher){
        Optional<Teacher> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        return optionalTeachers.get();
    }

    /**
     * Создать преподавателя \n
     * <b>Путь: /api/teachers/</b> \n
     * Тип запроса: POST
     * @param email -- почта преподавателя
     * @param firstName - имя преподавателя
     * @param patronymic -- отчество преподавателя
     * @param secondName -- фамилия преподавателя
     * @return Http Status 201 (CREATED), если сохранен объект
     */
    // TODO: 09.10.2020 написать исключение проверки одинаковых почт
    @PostMapping
    ResponseEntity<?> createTeacher(@RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String patronymic, @RequestParam String email){
        if (teacherRepository.findByEmail(email).isPresent()){
            throw new TeacherExistsException(email);
        }
        Teacher tempTeacher = new Teacher(firstName, secondName, patronymic, email);
        teacherRepository.save(tempTeacher);
        return new ResponseEntity<>("Teacher was created", HttpStatus.CREATED);

    }

    /**
     * Обновить преподавателя \n
     * <b>Путь: /api/teachers/{idTeachers}</b> \n
     * Тип запроса: PUT
     * @param idTeacher -- id преподавателя
     * @param firstName -- имя преподавателя
     * @param secondName -- фамилия преподавателя
     * @param patronymic -- отчество преподавателя
     * @param email -- почта преподавателя
     * @return Http Status 200 (OK), если обновлен объект,
     * если преподаватель с данным объектом отсутствует в базе, то выкидывает исключение TeacherNotFoundException
     * @throws TeacherNotFoundException
     */
    // TODO: 09.10.2020 аналогично с проверкой почты
    @PutMapping("/{idTeacher}")
    ResponseEntity<?> updateTeacher(@PathVariable Long idTeacher, @RequestParam String firstName,
                                    @RequestParam String secondName, @RequestParam String patronymic,
                                    @RequestParam String email){
        Optional<Teacher> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        Teacher tempTeacher = optionalTeachers.get();
        if (!tempTeacher.getEmail().equals(email)){
            tempTeacher.setEmail(email);
        }

        if (!tempTeacher.getFirstName().equals(firstName)){
            tempTeacher.setFirstName(firstName);
        }

        if (!tempTeacher.getSecondName().equals(secondName)){
            tempTeacher.setSecondName(secondName);
        }

        if (!tempTeacher.getPatronymic().equals(patronymic)){
            tempTeacher.setPatronymic(patronymic);
        }

        teacherRepository.save(tempTeacher);
        return new ResponseEntity<>("Teacher with id '" + idTeacher.toString() + "' updated", HttpStatus.OK);

    }

    /**
     * Удалить преподавателя \n
     * <b>Путь: /api/teachers/{idTeachers}</b> \n
     * Тип запроса: DELETE
     * @param idTeacher -- id преподавателя
     * @return HttpStatus 200 (OK) в случае успешного удаления объект,
     * если преподаватель с данным объектом отсутствует в базе, то выкидывает исключение TeacherNotFoundException
     */
    // TODO: 09.10.2020 связать удаление в бд
    @DeleteMapping("/{idTeacher}")
    ResponseEntity<?> deleteTeacher(@PathVariable Long idTeacher){
        Optional<Teacher> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        teacherRepository.delete(optionalTeachers.get());
        return new ResponseEntity<>("Teacher with id '" + idTeacher.toString() + "' was deleted", HttpStatus.OK);
    }

    /**
     * Получить список предметов, которые ведет преподаватель \n
     * <b>Путь: /api/teachers/{idTeachers}/subjects</b> \n
     * Тип запроса: GET
     * @param idTeacher -- id преподавателя
     * @return список предметов, которые ведет преподавателей,
     * если нет преподавателя с таким id, то выкидывает исключение TeacherNotFoundException
     * @throws TeacherNotFoundException
     */
    @GetMapping("/{idTeacher}/subjects")
    List<TeacherSubject> getTeacherSubjects(@PathVariable Long idTeacher){
        teacherRepository.findByIdTeacher(idTeacher).orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        return teacherSubjectRepository.findAllByTeacherIdTeacher(idTeacher);
    }

    /**
     * Удалить преподавателя \n
     * <b>Путь: /api/teachers/{idTeachers}</b> \n
     * Тип запроса: POST
     * @param idTeacher
     * @param idSubject
     * @return
     */

    @PostMapping("/{idTeacher}/subjects")
    ResponseEntity<?> createSubject(@PathVariable Long idTeacher, @RequestParam Long idSubject){
        Optional<Teacher> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        Optional<TeacherSubject> optionalTeacherSubject = teacherSubjectRepository.findByTeacherIdTeacher(idTeacher);
        Optional<Subject> optionalSubject = subjectRepository.findByIdSubject(idSubject);

        optionalSubject.orElseThrow(
                () -> new SubjectNotFoundException(idSubject.toString())
        );

        TeacherSubject tempTeacherSubject;
        if (optionalTeacherSubject.isPresent()){
            tempTeacherSubject = optionalTeacherSubject.get();
            List<Subject> tempList = tempTeacherSubject.getSubjects();
            if (!tempList.contains(optionalSubject.get())) {
                tempList.add(optionalSubject.get());
                tempTeacherSubject.setSubjects(tempList);
            }
        }
        else {
            List<Subject> tempList = new ArrayList<>();
            tempList.add(optionalSubject.get());
            tempTeacherSubject = new TeacherSubject(optionalTeachers.get(), tempList);
        }
        teacherSubjectRepository.save(tempTeacherSubject);
        return new ResponseEntity<>("Subject added to idTeacher '" + idTeacher.toString()+"'", HttpStatus.CREATED);
    }


    /**
     *
     * @param idTeacher
     * @param idSubject
     * @return
     */
    @GetMapping("/{idTeacher}/subjects/{idSubject}")
    Subject getSubjectById(@PathVariable Long idTeacher, @PathVariable Long idSubject){
        Optional<TeacherSubject> optionalTeacherSubject = this.teacherSubjectRepository.findByTeacherIdTeacher(idTeacher);
        optionalTeacherSubject.orElseThrow(
                () -> new TeacherSubjectNotFound(idTeacher.toString())
        );
         TeacherSubject teacherSubject = optionalTeacherSubject.get();
         Optional<Subject> optionalSubject = findInList(teacherSubject.getSubjects(), idSubject);
         optionalSubject.orElseThrow(
                 () -> new SubjectNotFoundException(idSubject.toString())
         );
         return optionalSubject.get();
         // todo: optimize this code
    }

    /**
     * Открепить предмет от преподавателя \n
     * <b>Путь: /api/teachers/{idTeacher}/{idSubject}</b> \n
     * Тип запроса: DELETE
     * @param idTeacher -- id преподавателя
     * @param idSubject -- id предмета
     * @return HttpStatus OK
     */
    @DeleteMapping("/{idTeacher}/subjects/{idSubject}")
    ResponseEntity<?> deleteTeacherSubject(@PathVariable Long idTeacher, @PathVariable Long idSubject){
        Optional<TeacherSubject> optionalTeacherSubject = this.teacherSubjectRepository.findByTeacherIdTeacher(idTeacher);
        optionalTeacherSubject.orElseThrow(
                () -> new TeacherSubjectNotFound(idTeacher.toString())
        );

        Optional<Subject> optionalSubject = subjectRepository.findByIdSubject(idSubject);
        optionalSubject.orElseThrow(
                () -> new SubjectNotFoundException(idSubject.toString())
        );
        Subject subject = optionalSubject.get();
        TeacherSubject teacherSubject = optionalTeacherSubject.get();
        List<Subject> subjectList = teacherSubject.getSubjects();
        subjectList.remove(subject);
        teacherSubject.setSubjects(subjectList);

        teacherSubjectRepository.save(teacherSubject);
        return new ResponseEntity<>("Teacher Subject with id '" + idTeacher +"' deleted", HttpStatus.OK);
    }

    /**
     * Получить группы, которые ведет преподаватель \n
     * <b>Путь: /api/teachers/{idTeacher}/{idSubject}</b> \n
     * Тип запроса: GET
     * @param idTeacher - id преподавателя
     * @return
     */
    @GetMapping("/{idTeacher}/groups")
    List<GroupTeacher> getGroupsByTeacher(@PathVariable Long idTeacher){
        Optional<Teacher> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        return groupTeacherRepository.findAllByTeachersContaining(optionalTeachers.get());
    }

    /**
     * Прикрепить преподавателя к группе \n
     * <b>Путь: /api/teachers/{idTeacher}/groups</b> \n
     * Тип запроса: POST
     * @param idTeacher -- id преподавателя
     * @param idGroup -- id группы
     * @return HttpStatus CREATED
     */
    @PostMapping("/{idTeacher}/groups")
    ResponseEntity<?> createTeacherGroup(@PathVariable Long idTeacher, @RequestParam Long idGroup){
        Optional<Teacher> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        Optional<GroupTeacher> optionalGroupTeacher = groupTeacherRepository.findByGroupIdGroup(idGroup);
        Optional<Group> optionalGroup = groupRepository.findByIdGroup(idGroup);

        optionalGroup.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        GroupTeacher tempGroupTeacher;
        if (optionalGroupTeacher.isPresent()){
            tempGroupTeacher = optionalGroupTeacher.get();
            List<Teacher> tempList = tempGroupTeacher.getTeachers();
            tempList.add(optionalTeachers.get());
            tempGroupTeacher.setTeachers(tempList);
        }
        else {
            List<Teacher> tempList = new ArrayList<>();
            tempList.add(optionalTeachers.get());
            tempGroupTeacher = new GroupTeacher(optionalGroup.get(), tempList);
        }
        groupTeacherRepository.save(tempGroupTeacher);
        return new ResponseEntity<>("Group connected to teacher", HttpStatus.CREATED);
    }

    // todo:

    /**
     * Открепить преподавателя от группы \n
     * <b>Путь: /api/teachers/{idTeacher}/{idGroup}</b> \n
     * Тип запроса: DELETE
     * @param idTeacher -- id преподавателя
     * @param idGroup -- id группы
     * @return HttpStatus OK
     */
    @DeleteMapping("/{idTeacher}/groups/{idGroup}")
    ResponseEntity<?> deleteTeacherGroup(@PathVariable Long idTeacher, @PathVariable Long idGroup){
        Optional<Teacher> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        Optional<GroupTeacher> optionalGroupTeacher = groupTeacherRepository.findByGroupIdGroup(idGroup);
        optionalGroupTeacher.orElseThrow(
                () -> new GroupTeacherNotFoundException(idGroup.toString())
        );

        Optional<Group> optionalGroup = groupRepository.findByIdGroup(idGroup);

        optionalGroup.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        GroupTeacher tempGroupTeacher = optionalGroupTeacher.get();
        List<Teacher> teachers = tempGroupTeacher.getTeachers();
        teachers.remove(optionalTeachers.get());
        groupTeacherRepository.delete(optionalGroupTeacher.get());
        return new ResponseEntity<>("Teacher with id '" + idTeacher.toString() +
                "' detached from group id '" + idGroup.toString() + "'", HttpStatus.OK);
    }


    Optional<Subject> findInList(List<Subject> listSubjects, Long idSubject){
        for (Subject subject: listSubjects){
            if (subject.getIdSubject() == idSubject){
                return Optional.of(subject);
            }
        }
        return Optional.empty();
    }

    @Autowired
    TeacherController(TeacherRepository teacherRepository, TeacherSubjectRepository teacherSubjectRepository,
                      SubjectRepository subjectRepository, GroupTeacherRepository groupTeacherRepository,
                      GroupRepository groupRepository){
        this.teacherRepository = teacherRepository;
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.subjectRepository = subjectRepository;
        this.groupTeacherRepository = groupTeacherRepository;
        this.groupRepository = groupRepository;
    }

}
