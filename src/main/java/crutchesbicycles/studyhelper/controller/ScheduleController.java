package crutchesbicycles.studyhelper.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import crutchesbicycles.studyhelper.domain.*;
import crutchesbicycles.studyhelper.exception.DayNotFoundException;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.exception.GroupTeacherNotFoundException;
import crutchesbicycles.studyhelper.exception.SubjectNotFoundException;
import crutchesbicycles.studyhelper.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleRecordRepository scheduleRecordRepository;
    private final GroupRepository groupRepository;
    private final DayRepository dayRepository;
    private final SubjectRepository subjectRepository;
    private final ScheduleRepository scheduleRepository;
    @GetMapping
    List<ScheduleRecord> getAllSchedules(){
        return scheduleRecordRepository.findAll();
    }

    /**
     * Создание еденицы расписания (пример -- блок пары в распиании мирэа) \n
     * <b>/api/schedules</b>
     * @param idGroup -- id группы
     * @param dayCaption - название дня (полное)
     * @param numberPair - номер пары
     * @param dateStart - во сколько начинается в формате "HH:mm:ss"
     * @param dateEnd - во сколько заканчивается пара "HH:mm:ss"
     * @param idSubjectEven - id предмета на четной неделе
     * @param idSubjectOdd - id предмета на нечетной неделе
     * @return HttpStatus Ok и саму сущность
     */
    @PostMapping
    ResponseEntity<?> createSchedule(@RequestParam Long idGroup, @RequestParam String dayCaption,
                                     @RequestParam Long numberPair, @RequestParam @JsonFormat(pattern = "HH:mm:ss") Date dateStart,
                                     @RequestParam @JsonFormat(pattern = "HH:mm:ss")Date dateEnd, @RequestParam Long idSubjectEven,
                                     @RequestParam Long idSubjectOdd){
        Group group = groupRepository.findByIdGroup(idGroup).orElseThrow(
                () -> new GroupNotFoundException(idGroup.toString())
        );

        Optional<Schedule> optionalSchedule = scheduleRepository.findByGroupIdGroup(idGroup);
        Schedule schedule = optionalSchedule.orElseGet(
                () -> new Schedule(group)
        );

        Day day = dayRepository.findByCaption(dayCaption).orElseThrow(
                () -> new DayNotFoundException(dayCaption)
        );

        Pair pair = new Pair(numberPair, dateStart, dateEnd);

        Subject subjectEven = subjectRepository.findByIdSubject(idSubjectEven).orElseThrow(
                () -> new SubjectNotFoundException(idSubjectEven.toString())
        );

        Subject subjectOdd = subjectRepository.findByIdSubject(idSubjectOdd).orElseThrow(
                () -> new SubjectNotFoundException(idSubjectOdd.toString())
        );

        ScheduleRecord returnedScheduleRecord = scheduleRecordRepository.save(new ScheduleRecord(schedule, day, pair, subjectEven, subjectOdd));

        return ResponseEntity.ok(returnedScheduleRecord);
    }


    @Autowired
    public ScheduleController(ScheduleRecordRepository scheduleRecordRepository, GroupRepository groupRepository,
                              DayRepository dayRepository, SubjectRepository subjectRepository, ScheduleRepository scheduleRepository) {
        this.scheduleRecordRepository = scheduleRecordRepository;
        this.groupRepository = groupRepository;
        this.dayRepository = dayRepository;
        this.subjectRepository = subjectRepository;
        this.scheduleRepository = scheduleRepository;
    }
}
