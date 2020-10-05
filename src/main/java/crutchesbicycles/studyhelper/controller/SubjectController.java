package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Subject;
import crutchesbicycles.studyhelper.domain.TeacherSubject;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.exception.SubjectNotFoundException;
import crutchesbicycles.studyhelper.repos.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectRepository subjectRepository;

    /**
     * Получить все предметы \n
     * <b>Путь: /api/subjects/</b> \n
     * Тип запроса: GET
     * @return Список предметов
     */
    @GetMapping
    List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    /**
     * Создать предмет \n
     * <b>Путь: /api/subjects/</b> \n
     * Тип запроса: POST
     * @return HTTP Status 201 CREATED
     */
    @PostMapping
    ResponseEntity<?> createSubject(@RequestParam String caption){
        Subject subject = new Subject(caption);
        subjectRepository.save(subject);
        return new ResponseEntity<>("Subject with caption '" + caption + "' created.", HttpStatus.CREATED);
    }


    /**
     * Получить предмет по id \n
     * <b>Путь: /api/subjects/{idSubject}</b> \n
     * Тип запроса: GET
     * @param idSubject (URL-шаблон) -- id предмета
     * @return сущность Subject, в случае отсутствия с данным id может выкинуть исключение SubjectNotFoundException
     * @throws SubjectNotFoundException
     */
    @GetMapping("/{idSubject}")
    Subject getSubjectById(@PathVariable Long idSubject){
        Optional<Subject> optionalSubject = subjectRepository.findByIdSubject(idSubject);
        optionalSubject.orElseThrow(
                () -> new SubjectNotFoundException(idSubject.toString())
        );

        return optionalSubject.get();
    }

    /**
     * Обновить поля предмета по id \n
     * <b>Путь: /api/subjects/{idSubject}</b> \n
     * Тип запроса: PUT
     * @param idSubject (URL-шаблон) -- id предмета
     * @return HttpStatus 200 (OK) в случае удачного обнавления, если отсутствует с данным id может выкинуть исключение SubjectNotFoundException
     * @throws SubjectNotFoundException
     */
    @PutMapping("/{idSubject}")
    ResponseEntity<?> updateSubject(@PathVariable Long idSubject, @RequestParam String caption){
        Optional<Subject> optionalSubject = subjectRepository.findByIdSubject(idSubject);
        optionalSubject.orElseThrow(
                () -> new SubjectNotFoundException(idSubject.toString())
        );

        Subject subject = optionalSubject.get();
        if (!subject.getCaption().equals(caption)){
            subject.setCaption(caption);
            subjectRepository.save(subject);
        }

        return new ResponseEntity<>("Subject with id '" + idSubject.toString() + "' updated", HttpStatus.OK);
    }

    /**
     * Удалить предмет по id \n
     * <b>Путь: /api/subjects/{idSubject}</b> \n
     * Тип запроса: DELETE
     * @param idSubject (URL-шаблон) -- id предмета
     * @return HttpStatus 200 (OK) в случае удачного удаления,
     * если отсутствует с данным id может выкинуть исключение SubjectNotFoundException
     * @throws SubjectNotFoundException
     */
    @DeleteMapping("/{idSubject}")
    ResponseEntity<?> deleteSubjectById(@PathVariable Long idSubject){
        Optional<Subject> optionalSubject = subjectRepository.findByIdSubject(idSubject);
        optionalSubject.orElseThrow(
                () -> new SubjectNotFoundException(idSubject.toString())
        );

        subjectRepository.delete(optionalSubject.get());
        return new ResponseEntity<>("Subject with id '" + idSubject.toString() + "' deleted", HttpStatus.OK);
    }

    @Autowired
    SubjectController(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }
}
