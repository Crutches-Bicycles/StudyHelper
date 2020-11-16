package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.ScheduleRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRecordRepository extends JpaRepository<ScheduleRecord, Long> {
    Optional<ScheduleRecord> findByIdScheduleRecord(Long idScheduleRecord);
    List<ScheduleRecord> findAll();

}
