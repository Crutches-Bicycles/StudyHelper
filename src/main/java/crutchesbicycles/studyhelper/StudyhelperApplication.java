package crutchesbicycles.studyhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StudyhelperApplication{

    public static void main(String[] args) {
        SpringApplication.run(StudyhelperApplication.class, args);
    }

}
