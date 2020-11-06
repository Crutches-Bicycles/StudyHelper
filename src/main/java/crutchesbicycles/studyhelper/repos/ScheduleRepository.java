package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.ScheduleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleRecord, Long> {

}
