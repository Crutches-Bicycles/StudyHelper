package crutchesbicycles.studyhelper;

import crutchesbicycles.studyhelper.exception.GroupExistsException;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
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
@Sql(value = {"/create-group-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-group-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GroupControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getGroupsTest() throws Exception{
        this.mockMvc.perform(get("/api/groups/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));;
    }
    @Test
    public void getGroupByIdTest() throws Exception{
        this.mockMvc.perform(get("/api/groups/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idGroup").value(10));
    }
    @Test
    public void GroupNotFoundExceptionTest() throws Exception{
        this.mockMvc.perform(get("/api/groups/12"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof GroupNotFoundException));
    }
    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})

    public void updateGroupByIdTest() throws Exception{
        this.mockMvc.perform(put("/api/groups/10")
                .param("caption","EXAMPLE1")
                .param("email","example5@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("updated")));
       /* this.mockMvc.perform(get("/api/groups/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("example5@gmail.com"));*/
    }
    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    // TODO: 30.11.2020 Выбрасывает исключение только при одновременном изменении почты и названия на существующие 
    // TODO: 30.11.2020 При изменении только названия или только почты не выбрасывает исключение
    public void GroupExistsExceptionTest() throws Exception{
        this.mockMvc.perform(put("/api/groups/10")
                .param("email","example2@gmail.com")
                .param("caption","example1"))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof GroupExistsException));
    }
    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    // TODO: 30.11.2020 Не понимаю, почему нужно использовать WithMockUser, если в контроллере не используется PreAuthorize
    public void createGroupTest() throws Exception{
        this.mockMvc.perform(post("/api/groups")
                .param("caption","EXAMPLE3")
                .param("email","example3@gmail.com"))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Group was created")));
        this.mockMvc.perform(get("/api/groups"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }
    @Test
    @WithMockUser(roles = {"USER", "ADMIN"})
    // TODO: 30.11.2020 По прежнему невозможно удалить из-за зависимостей в таблице 
    public void deleteGroupTest() throws Exception{
        this.mockMvc.perform(delete("/api/groups/10"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Group with id '10' deleted")));
        this.mockMvc.perform(get("/api/groups/10"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof GroupNotFoundException));
    }
    @Test
    public void  getTeacherGroupTest() throws Exception{
        this.mockMvc.perform(get("/api/groups/10/teachers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.teachers",hasSize(2)))
                .andExpect(jsonPath("$.teachers[0].firstName").value("Иван"));
    }
}

