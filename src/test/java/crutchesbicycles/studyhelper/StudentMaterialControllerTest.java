package crutchesbicycles.studyhelper;

import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.StudentMaterialNotFoundException;
import crutchesbicycles.studyhelper.exception.StudentNotFoundException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
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
@Sql(value = {"/create-studentmaterial-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-studentmaterial-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class StudentMaterialControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getStudentMaterialTest() throws Exception{
        this.mockMvc.perform(get("/api/students/10/materials"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

    @Test
    public void StudentNotFoundExceptionTest() throws Exception{
        this.mockMvc.perform(get("/api/students/15/materials"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException));
    }

    @Test
    public void getStudentMaterialByIdTest() throws Exception{
        this.mockMvc.perform(get("/api/students/10/materials/12"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.file").value("exampleFile3"));
    }
    @Test
    public  void StudentMaterialNotFoundException()throws Exception{
        this.mockMvc.perform(get("/api/students/10/materials/15"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentMaterialNotFoundException));
    }
}
