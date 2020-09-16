package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teachers, Long> {
    List<Teachers> findAll();
}
