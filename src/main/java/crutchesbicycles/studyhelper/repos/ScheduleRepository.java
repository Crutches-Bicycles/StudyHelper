package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Schedule;
import crutchesbicycles.studyhelper.domain.ScheduleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByGroupIdGroup(Long idGroup);
}
