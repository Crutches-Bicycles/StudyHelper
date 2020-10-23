package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdStudent(Long idStudent);
    List<Student> findAll();
}
