package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Teachers;
import crutchesbicycles.studyhelper.exception.TeacherNotFoundException;
import crutchesbicycles.studyhelper.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    TeacherRepository teacherRepository;

    @GetMapping
    List<Teachers> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/{idTeacher}")
    Teachers getTeacherById(@PathVariable Long idTeacher){
        Optional<Teachers> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        return optionalTeachers.get();
    }

    @PostMapping
    ResponseEntity<?> createTeacher(@RequestParam String firstName, @RequestParam String secondName,
                                    @RequestParam String patronymic, @RequestParam String email){
        Teachers  tempTeacher = new Teachers(firstName, secondName, patronymic, email);
        teacherRepository.save(tempTeacher);
        return new ResponseEntity<>("Teacher was created", HttpStatus.CREATED);

    }

    @PutMapping("/{idTeacher}")
    ResponseEntity<?> updateTeacher(@PathVariable Long idTeacher, @RequestParam String firstName,
                                    @RequestParam String secondName, @RequestParam String patronymic,
                                    @RequestParam String email){
        Optional<Teachers> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        Teachers tempTeacher = optionalTeachers.get();
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

    @DeleteMapping("/{idTeacher}")
    ResponseEntity<?> deleteTeacher(@PathVariable Long idTeacher){
        Optional<Teachers> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        teacherRepository.delete(optionalTeachers.get());
        return new ResponseEntity<>("Teacher with id '" + idTeacher.toString() + "' was deleted", HttpStatus.OK);
    }

    @Autowired
    TeacherController(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

}
