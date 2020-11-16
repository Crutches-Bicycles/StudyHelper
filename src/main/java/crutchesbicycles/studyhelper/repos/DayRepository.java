package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Long> {
    Optional<Day> findByCaption(String caption);

}
