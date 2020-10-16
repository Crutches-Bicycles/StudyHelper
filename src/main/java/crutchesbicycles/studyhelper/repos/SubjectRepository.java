package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByIdSubject(Long idSubject);
    Optional<Subject> findByCaption(String caption);
}
