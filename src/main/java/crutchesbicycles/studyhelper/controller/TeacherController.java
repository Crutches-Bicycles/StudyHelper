package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.ListSubjects;
import crutchesbicycles.studyhelper.domain.TeacherSubject;
import crutchesbicycles.studyhelper.domain.Teachers;
import crutchesbicycles.studyhelper.exception.SubjectNotFoundException;
import crutchesbicycles.studyhelper.exception.TeacherNotFoundException;
import crutchesbicycles.studyhelper.exception.TeacherSubjectNotFound;
import crutchesbicycles.studyhelper.repos.SubjectRepository;
import crutchesbicycles.studyhelper.repos.TeacherRepository;
import crutchesbicycles.studyhelper.repos.TeacherSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    TeacherRepository teacherRepository;
    TeacherSubjectRepository teacherSubjectRepository;
    SubjectRepository subjectRepository;

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

    @GetMapping("/{idTeacher}/subjects")
    List<TeacherSubject> getTeacherSubjects(@PathVariable Long idTeacher){
        teacherRepository.findByIdTeacher(idTeacher).orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        return teacherSubjectRepository.findAllByTeacherIdTeacher(idTeacher);
    }

    @PostMapping("/{idTeacher}/subjects")
    ResponseEntity<?> createSubject(@PathVariable Long idTeacher, @RequestParam Long idSubject){
        Optional<Teachers> optionalTeachers = teacherRepository.findByIdTeacher(idTeacher);
        optionalTeachers.orElseThrow(
                () -> new TeacherNotFoundException(idTeacher.toString())
        );

        Optional<TeacherSubject> optionalTeacherSubject = teacherSubjectRepository.findByTeacherIdTeacher(idTeacher);
        Optional<ListSubjects> optionalSubject = subjectRepository.findByIdSubject(idSubject);

        optionalSubject.orElseThrow(
                () -> new SubjectNotFoundException(idSubject.toString())
        );

        TeacherSubject tempTeacherSubject;
        if (optionalTeacherSubject.isPresent()){
            tempTeacherSubject = optionalTeacherSubject.get();
            List<ListSubjects> tempList = tempTeacherSubject.getSubjects();
            tempList.add(optionalSubject.get());
            tempTeacherSubject.setSubjects(tempList);
        }
        else {
            List<ListSubjects> tempList = new ArrayList<>();
            tempList.add(optionalSubject.get());
            tempTeacherSubject = new TeacherSubject(optionalTeachers.get(), tempList);
        }
        teacherSubjectRepository.save(tempTeacherSubject);
        return new ResponseEntity<>("Subject added to idTeacher '" + idTeacher.toString()+"'", HttpStatus.CREATED);
    }


    @GetMapping("/{idTeacher}/subjects/{idSubject}")
    ListSubjects getSubjectById(@PathVariable Long idTeacher, @PathVariable Long idSubject){
        Optional<TeacherSubject> optionalTeacherSubject = this.teacherSubjectRepository.findByTeacherIdTeacher(idTeacher);
        optionalTeacherSubject.orElseThrow(
                () -> new TeacherSubjectNotFound(idTeacher.toString())
        );
         TeacherSubject teacherSubject = optionalTeacherSubject.get();
         Optional<ListSubjects> optionalSubject = findInList(teacherSubject.getSubjects(), idSubject);
         optionalSubject.orElseThrow(
                 () -> new SubjectNotFoundException(idSubject.toString());
         );
         return optionalSubject.get();
         // todo: optimize this code
    }


    Optional<ListSubjects> findInList(List<ListSubjects> listSubjects, Long idSubject){
        for (ListSubjects subject: listSubjects){
            if (subject.getIdSubject() == idSubject){
                return Optional.of(subject);
            }
        }
        return Optional.empty();
    }

    @Autowired
    TeacherController(TeacherRepository teacherRepository, TeacherSubjectRepository teacherSubjectRepository,
                      SubjectRepository subjectRepository){
        this.teacherRepository = teacherRepository;
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.subjectRepository = subjectRepository;
    }

}
