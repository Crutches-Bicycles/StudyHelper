package crutchesbicycles.studyhelper;

import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest
@WithMockUser(roles = {"ADMIN","USER"})
@Sql(value = {"/create-schedule-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-schedule-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class ScheduleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllSchedulesTest()throws Exception{
        this.mockMvc.perform(get("/api/schedules"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }

    @Test
    // TODO: 01.12.2020 Возмодно стоит поменять JsonFormat на DateTimeFormat 
    // TODO: 01.12.2020 Ругается на запись, возможно, из-за отсутствия репозитория пар 
    public void createScheduleTest()throws Exception{
        this.mockMvc.perform(post("/api/schedules/")
                .param("idGroup","10")
                .param("dayCaption","Понедельник")
                .param("numberPair","1")
                .param("dateStart","09:00:00")
                .param("dateEnd","10:30:00")
                .param("idSubjectEven","10")
                .param("idSubjectOdd","11"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(123));
    }
}
