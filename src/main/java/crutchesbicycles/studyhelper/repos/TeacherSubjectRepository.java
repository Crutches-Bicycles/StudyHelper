package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.TeacherSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, Long> {
    List<TeacherSubject> findAllByTeacherIdTeacher(Long idTeacher);
    Optional<TeacherSubject> findByTeacherIdTeacher(Long idTeacher);


}
