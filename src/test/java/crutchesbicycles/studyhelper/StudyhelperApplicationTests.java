package crutchesbicycles.studyhelper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class StudyhelperApplicationTests {
    @Autowired
    private StudyhelperApplication SHA;

    @Test
    public void contextLoads() throws Exception {
        assertThat(SHA).isNotNull();
    }

}
