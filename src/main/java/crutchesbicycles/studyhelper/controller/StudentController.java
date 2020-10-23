package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Group;
import crutchesbicycles.studyhelper.domain.Student;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.exception.StudentNotFoundException;
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

    /**
     * Возвращает список студентов.
     * @return
     */
    @GetMapping
    List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    ResponseEntity<?> createStudent(@RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String patronymic, @RequestParam Long idGroup){
        Optional<Group> groupOptional = groupRepository.findByIdGroup(idGroup);
        groupOptional.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );
        Student student = new Student(groupOptional.get(), firstName, secondName, patronymic);
        long idStudent = studentRepository.save(student).getIdStudent();
        return new ResponseEntity<>("Student with id '" + idStudent + "' created", HttpStatus.CREATED);
    }

    @GetMapping("{idStudent}")
    Student getStudentById(@PathVariable Long idStudent){
        Optional<Student> student = studentRepository.findByIdStudent(idStudent);
        student.orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );
        return student.get();
    }

    @DeleteMapping("{idStudent}")
    ResponseEntity<?> deleteStudent(@PathVariable Long idStudent){
        Optional<Student> student = studentRepository.findByIdStudent(idStudent);
        student.orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );
        studentRepository.deleteById(idStudent);
        return new ResponseEntity<>("Student with id '" + idStudent + "' deleted", HttpStatus.OK);
    }

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

        return new ResponseEntity<>("Student with id '" + idStudent.toString() + "' updated", HttpStatus.OK);
    }

    @Autowired
    public StudentController(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }
}
