package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Groups;
import crutchesbicycles.studyhelper.domain.Students;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.exception.StudentNotFoundException;
import crutchesbicycles.studyhelper.repos.GroupRepository;
import crutchesbicycles.studyhelper.repos.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentsRepository studentRepository;
    private final GroupRepository groupRepository;

    @GetMapping
    List<Students> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    ResponseEntity<?> createStudent(@RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String patronymic, @RequestParam Long idGroup){
        Optional<Groups> groupOptional = groupRepository.findByIdGroup(idGroup);
        groupOptional.orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );
        Students student = new Students(groupOptional.get(), firstName, secondName, patronymic);
        long idStudent = studentRepository.save(student).getIdStudent();
        return new ResponseEntity<>("Student with id '" + idStudent + "' created", HttpStatus.CREATED);
    }

    @GetMapping("{idStudent}")
    Students getStudentById(@PathVariable Long idStudent){
        Optional<Students> student = studentRepository.findByIdStudent(idStudent);
        student.orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );
        return student.get();
    }

    @DeleteMapping("{idStudent}")
    ResponseEntity<?> deleteStudent(@PathVariable Long idStudent){
        Optional<Students> student = studentRepository.findByIdStudent(idStudent);
        student.orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );
        return new ResponseEntity<>("Student with id '" + idStudent + "' deleted", HttpStatus.OK);
    }

    @Autowired
    public StudentController(StudentsRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }
}
