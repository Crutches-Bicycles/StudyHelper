package crutchesbicycles.studyhelper;


import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
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
@Sql(value = {"/create-account-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-account-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAccountsTest() throws Exception {
        this.mockMvc.perform(get("/api/accounts/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }
    @Test
    public void createAccountTest() throws Exception {
        this.mockMvc.perform(post("/api/accounts/")
                .param("email","example2@gmail.com")
                .param("password","123")
                .param("accountType","ADMIN"))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Account with email example2@gmail.com Created")));
        this.mockMvc.perform(get("/api/accounts/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }
    @Test
    public void AccountExistsExceptionTest() throws Exception {
        this.mockMvc.perform(post("/api/accounts/")
                .param("email","example@gmail.com")
                .param("password","123")
                .param("accountType","ADMIN"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof AccountExistsException));
    }

    @Test
    public void getAccountByIdTest() throws Exception {
        this.mockMvc.perform(get("/api/accounts/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idAccount").value(10));
    }

    @Test
    public void UserNotFoundExceptionTest() throws Exception{
        this.mockMvc.perform(get("/api/accounts/12"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException));
    }

    @Test
    // TODO: 09.10.2020 Нет обработки изменения почты на уже существующую
    public void editAccountTest() throws Exception{
        this.mockMvc.perform(put("/api/accounts/10")
                .param("email","example3@gmail.com")
                .param("password","1")
                .param("accountType","ADMIN")
                .param("idStudent",""))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Information updated: 10")));
        this.mockMvc.perform(get("/api/accounts/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("example3@gmail.com"));

    }

    @Test
    public void deleteAccountTest() throws Exception{
        this.mockMvc.perform(delete("/api/accounts/10"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Account with Id '10' deleted")));
        this.mockMvc.perform(get("/api/accounts/10"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException));
    }
}


