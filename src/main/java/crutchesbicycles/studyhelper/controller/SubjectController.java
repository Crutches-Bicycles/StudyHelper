package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.ListSubjects;
import crutchesbicycles.studyhelper.repos.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subjects/")
public class SubjectController {
    private final SubjectRepository subjectRepository;

    @GetMapping
    List<ListSubjects> getAllSubjects(){
        return subjectRepository.findAll();
    }
    
    @Autowired
    SubjectController(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }
}
