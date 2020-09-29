package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.ListSubjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SubjectRepository extends JpaRepository<ListSubjects, Long> {
    Optional<ListSubjects> findByIdSubject(Long idSubject);

}
