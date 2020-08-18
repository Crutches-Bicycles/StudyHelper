package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    Optional<Students> findByIdStudent(Long idStudent);
    List<Students> findAll();
}
