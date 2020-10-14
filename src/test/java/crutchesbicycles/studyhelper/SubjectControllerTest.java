package crutchesbicycles.studyhelper;


import crutchesbicycles.studyhelper.exception.SubjectNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
@Sql(value = {"/create-subject-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-subject-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class SubjectControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllSubjectsTest()throws Exception{
        this.mockMvc.perform(get("/api/subjects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[0].caption").value("first"));
    }
    @Test
    // TODO: 09.10.2020 Нет обработки создания одинаковых предметов
    public void createSubjectTest()throws Exception{
        this.mockMvc.perform(post("/api/subjects")
                .param("caption","fourth"))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Subject with caption 'fourth' created.")));
        this.mockMvc.perform(get("/api/subjects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(4)));
    }
    @Test
    public void getSubjectByIdTest()throws Exception{
        this.mockMvc.perform(get("/api/subjects/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.caption").value("first"));
    }
    @Test
    public void SubjectNotFoundExceptionTest()throws Exception{
        this.mockMvc.perform(get("/api/subjects/13"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof SubjectNotFoundException));
    }

    @Test
    // TODO: 09.10.2020 Нет обработки изменения имени на существующее
    public void updateSubjectTest()throws Exception{
        this.mockMvc.perform(put("/api/subjects/10")
                .param("caption","fifth"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Subject with id '10' updated")));
        this.mockMvc.perform(get("/api/subjects/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.caption").value("fifth"));
    }

   @Test
    public void deleteSubjectTest() throws Exception{
        this.mockMvc.perform(delete("/api/subjects/10"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Subject with id '10' deleted")));
        this.mockMvc.perform(get("/api/subjects/10"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof SubjectNotFoundException));
   }
}
