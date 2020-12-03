package crutchesbicycles.studyhelper;
import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest
@Sql(value = {"/create-account-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-account-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerTest()throws Exception{
        this.mockMvc.perform(post("/api/auth/register")
                .param("email", "example2@gmail.com")
                .param("password", "1")
                .param("i", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("example2@gmail.com"))
                .andExpect(jsonPath("$.roles",hasSize(2)));
    }

    @Test
    public void AccountExistsExceptionTest()throws Exception{
        this.mockMvc.perform(post("/api/auth/register")
                .param("email", "example1@gmail.com")
                .param("password", "1")
                .param("i", "1"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof AccountExistsException));
    }
    @Test
    public void loginTest() throws Exception{
        this.mockMvc.perform(post("/api/auth/login")
                .param("email","example1@gmail.com")
                .param("password","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("example1@gmail.com"));
    }

    @Test
    // TODO: 30.11.2020 странное исключение
    public void BadCredentialsExceptionTest()throws Exception{
        this.mockMvc.perform(post("/api/auth/login")
                .param("email","example1@gmail.com")
                .param("password","12"))
                .andExpect(status().isForbidden())
                .andExpect(result ->assertTrue(result.getResolvedException()instanceof BadCredentialsException));
    }
}
