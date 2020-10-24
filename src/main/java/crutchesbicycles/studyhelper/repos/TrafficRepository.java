package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrafficRepository extends JpaRepository<Traffic, Long> {
    List<Traffic> findAll();
    List<Traffic> findAllByStudentIdStudent(Long idStudent);
    Optional<Traffic> findByIdTraffic(Long idTraffic);
}
