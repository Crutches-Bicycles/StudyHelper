package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.domain.Group;
import crutchesbicycles.studyhelper.domain.Student;
import crutchesbicycles.studyhelper.exception.AccountNotFoundException;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.exception.StudentNotFoundException;
import crutchesbicycles.studyhelper.repos.AccountRepository;
import crutchesbicycles.studyhelper.repos.GroupRepository;
import crutchesbicycles.studyhelper.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final AccountRepository accountRepository;

    /**
     * Возвращает список студентов. \n
     * <b>Путь: /api/students/</b> \n
     * Тип запроса: GET
     * @return список студентов {@link Student}
     */
    @GetMapping
    List<Student> getStudents(){
        return studentRepository.findAll();
    }

    /**
     * Создает студениа и прикрепляет к аккаунту \n
     * <b>Путь: /api/students</b> \n
     * @param firstName -- имя
     * @param secondName -- фамилия
     * @param patronymic -- отчество
     * @param idGroup -- номер группы
     * @param idAccount -- id аккаунта к которому будет прикрепелен студент
     * @return HttpStatus OK с телом {@link Account} в случае удачного выполнения запрос, также может выдать исключения GroupNotFoundException,
     * AccountNotFoundException
     */
    @PostMapping
    ResponseEntity<?> createStudent(@RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String patronymic, @RequestParam Long idGroup,
                                    @RequestParam Long idAccount){
        Optional<Group> groupOptional = groupRepository.findByIdGroup(idGroup);
        groupOptional.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );
        Student student = new Student(groupOptional.get(), firstName, secondName, patronymic);
        long idStudent = studentRepository.save(student).getIdStudent();

        Optional<Account> accountOptional = accountRepository.findByIdAccount(idAccount);
        accountOptional.orElseThrow(
                () -> new AccountNotFoundException(idAccount.toString())
        );

        Account account = accountOptional.get();
        account.setStudent(student);
        accountRepository.save(account);

        return ResponseEntity.ok(account);
    }

    /**
     * Получить студента по id \n
     * <b>Путь: /api/students/{idStudent}</b> \n\n
     * Тип запроса: GET
     * @param idStudent -- id студента
     * @return сущность студента {@link Student}
     */
    @GetMapping("{idStudent}")
    Student getStudentById(@PathVariable Long idStudent){
        Optional<Student> student = studentRepository.findByIdStudent(idStudent);
        student.orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );
        return student.get();
    }

    /**
     * Удаляет студента в системе \n
     * <b>Путь: /api/students/{idStudent}</b> \n
     * Тип запроса: DELETE
     * @param idStudent -- id студента 
     * @return HttpStatus Ok с id удаленного студента ({@link Student}), может выдать исключение {@link StudentNotFoundException}
     */
    @DeleteMapping("{idStudent}")
    ResponseEntity<?> deleteStudent(@PathVariable Long idStudent){
        Optional<Student> student = studentRepository.findByIdStudent(idStudent);
        student.orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );
        studentRepository.deleteById(idStudent);
        return new ResponseEntity<>("Student with id '" + idStudent + "' deleted", HttpStatus.OK);
    }

    /**
     * Обновляет студента в системе \n
     * <b>Путь: /api/students/{idStudent}</b> \n
     * Тип запроса: PUT
     * @param idStudent -- id студента
     * @return HttpStatus Ok с данными обновленного студента ({@link Student}), может выдать исключение {@link StudentNotFoundException}
     */
    @PutMapping("{idStudent}")
    ResponseEntity<?> updateStudent(@PathVariable Long idStudent,
                                    @RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String patronymic, @RequestParam Long idGroup){
        Optional<Student> optionalStudent = studentRepository.findByIdStudent(idStudent);
        optionalStudent.orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );

        Student tempStudent = optionalStudent.get();
        if (!tempStudent.getFirstName().equals(firstName)){
            tempStudent.setFirstName(firstName);
        }

        if (!tempStudent.getSecondName().equals(secondName)){
            tempStudent.setSecondName(secondName);
        }

        if (!tempStudent.getPatronymic().equals(patronymic)){
            tempStudent.setPatronymic(patronymic);
        }

        Optional<Group> optionalGroup = groupRepository.findByIdGroup(idGroup);
        optionalGroup.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        Long tempIdGroup = tempStudent.getGroup().getIdGroup();
        if (!tempIdGroup.toString().equals(idGroup)){
            tempStudent.setGroup(optionalGroup.get());
        }

        studentRepository.save(tempStudent);

        return ResponseEntity.ok(tempStudent);
    }

    @Autowired
    public StudentController(StudentRepository studentRepository, GroupRepository groupRepository, AccountRepository accountRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.accountRepository = accountRepository;
    }

}
