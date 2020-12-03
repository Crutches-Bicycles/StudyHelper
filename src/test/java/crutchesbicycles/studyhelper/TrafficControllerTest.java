package crutchesbicycles.studyhelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.bind.v2.TODO;
import crutchesbicycles.studyhelper.controller.AccountController;
import crutchesbicycles.studyhelper.domain.Group;
import crutchesbicycles.studyhelper.domain.Subject;
import crutchesbicycles.studyhelper.domain.TeacherSubject;
import crutchesbicycles.studyhelper.exception.*;
import crutchesbicycles.studyhelper.repos.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.debugging.MockitoDebuggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest
@WithMockUser(roles = {"USER","ADMIN"})
@Sql(value = {"/create-traffic-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-traffic-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TrafficControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    // TODO: 01.12.2020 Нет исключения для несуществующего студента
    public void getTrafficByStudentTest()throws Exception{
        this.mockMvc.perform(get("/api/students/10/traffic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }
    @Test
    public void getTrafficByIdTest()throws Exception{
        this.mockMvc.perform(get("/api/traffic/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap());
    }
    @Test
    public void TrafficNotFoundExceptionTest()throws Exception{
        this.mockMvc.perform(get("/api/traffic/15"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException()instanceof TrafficNotFoundException));
    }
    @Test
    // TODO: 01.12.2020 Формат DATE, а не DATE_TIME
    public void createTrafficTest()throws  Exception{
        this.mockMvc.perform(post("/api/students/10/traffic")
                .param("idSchedule","10")
                .param("date","2020-10-15")
                .param("isAttend","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.attend").value(true));
    }

}
