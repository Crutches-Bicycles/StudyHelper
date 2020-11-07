package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.*;
import crutchesbicycles.studyhelper.exception.ScheduleRecordNotFoundException;
import crutchesbicycles.studyhelper.exception.StudentNotFoundException;
import crutchesbicycles.studyhelper.exception.TrafficNotFoundException;
import crutchesbicycles.studyhelper.repos.ScheduleRecordRepository;
import crutchesbicycles.studyhelper.repos.StudentRepository;
import crutchesbicycles.studyhelper.repos.TrafficRepository;
import crutchesbicycles.studyhelper.security.jwt.JwtUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TrafficController {

    private final TrafficRepository trafficRepository;
    private final StudentRepository studentRepository;
    private final ScheduleRecordRepository scheduleRecordRepository;

    @GetMapping("/students/{idStudent}/traffic")
    List<Traffic> getTrafficByStudent(@PathVariable Long idStudent){
        return trafficRepository.findAllByStudentIdStudent(idStudent);
    }

    @GetMapping("/traffic/{idTraffic}")
    Traffic getTrafficById(@PathVariable Long idTraffic){
        Optional<Traffic> optionalTraffic = trafficRepository.findByIdTraffic(idTraffic);
        optionalTraffic.orElseThrow(
                () -> new TrafficNotFoundException(idTraffic.toString())
        );
        return optionalTraffic.get();
    }


    @PostMapping("/students/{idStudent}/traffic")
    ResponseEntity<?> createTraffic(@PathVariable Long idStudent, @RequestParam Long idSchedule,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date,
                                    @RequestParam Boolean isAttend){

        Student student = studentRepository.findByIdStudent(idStudent).orElseThrow(
                () -> new StudentNotFoundException(idStudent.toString())
        );

        ScheduleRecord scheduleRecord = this.scheduleRecordRepository.findByIdScheduleRecord(idSchedule).orElseThrow(
                () -> new ScheduleRecordNotFoundException(idSchedule.toString())
        );

        Traffic traffic = trafficRepository.save(new Traffic(student, scheduleRecord, date, isAttend));

        return ResponseEntity.ok(traffic);
    }

    @Autowired
    public TrafficController(TrafficRepository trafficRepository, StudentRepository studentRepository,
                             ScheduleRecordRepository scheduleRecordRepository) {
        this.trafficRepository = trafficRepository;
        this.studentRepository = studentRepository;
        this.scheduleRecordRepository = scheduleRecordRepository;
    }
}
