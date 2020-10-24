package crutchesbicycles.studyhelper.controller;

import crutchesbicycles.studyhelper.domain.Traffic;
import crutchesbicycles.studyhelper.exception.TrafficNotFoundException;
import crutchesbicycles.studyhelper.repos.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrafficController {

    public final TrafficRepository trafficRepository;

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

    // TODO: 24.10.2020 доделать завтра
    @PostMapping("/students/{idStudent}/traffic")
    ResponseEntity<?> createTraffic(){
        return new ResponseEntity<>("Traffic created", HttpStatus.CREATED);
    }

    @Autowired
    public TrafficController(TrafficRepository trafficRepository) {
        this.trafficRepository = trafficRepository;
    }
}
