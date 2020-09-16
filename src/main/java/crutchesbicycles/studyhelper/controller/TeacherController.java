package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Teachers;
import crutchesbicycles.studyhelper.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    TeacherRepository teacherRepository;

    @GetMapping
    List<Teachers> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @PostMapping
    ResponseEntity<?> createTeacher(@RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String patronymic, @RequestParam String email){
        Teachers  tempTeacher = new Teachers(firstName, secondName, patronymic, email);
        teacherRepository.save(tempTeacher);
        return new ResponseEntity<>("Teacher was created", HttpStatus.CREATED);

    }

    @Autowired
    TeacherController(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

}
