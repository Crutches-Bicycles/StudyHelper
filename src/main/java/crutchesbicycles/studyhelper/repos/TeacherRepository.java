package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teachers, Long> {
    List<Teachers> findAll();
    Optional<Teachers> findByIdTeacher(Long idTeacher);
}
