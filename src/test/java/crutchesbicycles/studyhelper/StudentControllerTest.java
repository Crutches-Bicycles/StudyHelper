package crutchesbicycles.studyhelper;

import crutchesbicycles.studyhelper.exception.AccountNotFoundException;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.exception.StudentNotFoundException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest
@Sql(value = {"/create-student-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-student-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    public void getStudentsTest() throws Exception{
        this.mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    // TODO: 01.12.2020 Можно привязать к аккауту, у которого уже есть студент 
    public void createStudentTest() throws Exception{
        this.mockMvc.perform(post("/api/students")
                .param("firstName","Андрей")
                .param("secondName","Андреев")
                .param("patronymic","Андреевич")
                .param("idGroup","10")
                .param("idAccount","12"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.student.firstName").value("Андрей"));
        this.mockMvc.perform(get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));

    }
    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    public void GroupNotFoundException() throws Exception{
        this.mockMvc.perform(post("/api/students")
                .param("firstName", "Андрей")
                .param("secondName", "Андреев")
                .param("patronymic", "Андреевич")
                .param("idGroup", "13")
                .param("idAccount","12"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof GroupNotFoundException));
    }

    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    public void AccountNotFoundException() throws Exception{
        this.mockMvc.perform(post("/api/students")
                .param("firstName", "Андрей")
                .param("secondName", "Андреев")
                .param("patronymic", "Андреевич")
                .param("idGroup", "10")
                .param("idAccount","13"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof AccountNotFoundException));
    }

    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    public void getStudentByIdTest() throws Exception{
        this.mockMvc.perform(get("/api/students/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idStudent").value(10));
    }

    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    public void StudentNotFoundExceptionTest()throws Exception{
        this.mockMvc.perform(get("/api/students/15"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException));
    }

    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    // TODO: 01.12.2020 Нельзя удалить из-за связи с аккаунтом
    public void deleteStudentTest() throws Exception{
        this.mockMvc.perform(delete("/api/students/10"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("deleted")));
        this.mockMvc.perform(get("/api/students/10"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException));
    }

    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    // TODO: 01.12.2020 Можно поменять на аккаунт, у которого уже есть студент
    public void updateStudentTest() throws Exception{
        this.mockMvc.perform(put("/api/students/10")
                .param("firstName","Igor")
                .param("secondName","Игорев")
                .param("patronymic","Игоревич")
                .param("idGroup","10")
                .param("idAccount","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Igor"));
        this.mockMvc.perform(get("/api/students/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Igor"));
    }




}