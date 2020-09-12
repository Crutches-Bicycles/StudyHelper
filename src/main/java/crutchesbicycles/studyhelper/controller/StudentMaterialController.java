package crutchesbicycles.studyhelper.controller;


import crutchesbicycles.studyhelper.domain.StudentMaterial;
import crutchesbicycles.studyhelper.exception.StudentMaterialNotFoundException;
import crutchesbicycles.studyhelper.exception.StudentNotFoundException;
import crutchesbicycles.studyhelper.repos.StudentMaterialRepository;
import crutchesbicycles.studyhelper.repos.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentMaterialController {
    //todo: не забыть передавать в FileUploadController уже модифицированное имя файла, чтобы не было колизий
    private final StudentMaterialRepository studentMaterialRepository;
    private final StudentsRepository studentsRepository;

    @GetMapping("/{idStudent}/materials")
    List<StudentMaterial> getStudentMaterial(@PathVariable Long idStudent){
        checkStudentById(idStudent);
        return studentMaterialRepository.findByStudentIdStudent(idStudent);
    }

    @GetMapping("/{idStudent}/materials/{idMaterial}")
    StudentMaterial getStudentMaterialById(@PathVariable Long idStudent, @PathVariable Long idMaterial){
        checkStudentById(idStudent);
        Optional<StudentMaterial> optionalStudentMaterial = studentMaterialRepository.findByStudentIdStudentAndIdMaterial(idStudent, idMaterial);
        optionalStudentMaterial.orElseThrow(
                () -> new StudentMaterialNotFoundException(idStudent.toString(), idMaterial.toString())
        );
        return optionalStudentMaterial.get();
    }

    void checkStudentById(Long idStudent){
        studentsRepository.findByIdStudent(idStudent).orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );
    }

    @Autowired
    StudentMaterialController(StudentMaterialRepository studentMaterialRepository, StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
        this.studentMaterialRepository = studentMaterialRepository;
    }
}
