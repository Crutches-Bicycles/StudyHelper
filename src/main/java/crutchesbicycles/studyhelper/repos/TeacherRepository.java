package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAll();
    Optional<Teacher> findByIdTeacher(Long idTeacher);
}
