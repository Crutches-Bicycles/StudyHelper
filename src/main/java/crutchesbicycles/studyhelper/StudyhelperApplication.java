package crutchesbicycles.studyhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

// автоматическая настройка безопасности
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableCaching
public class StudyhelperApplication{

    public static void main(String[] args) {
        SpringApplication.run(StudyhelperApplication.class, args);
    }

}
