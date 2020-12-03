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
@Sql(value = {"/create-teacher-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-teacher-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TeacherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllTeachersTest() throws Exception {
        this.mockMvc.perform(get("/api/teachers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getTeacherByIdTest() throws Exception {
        this.mockMvc.perform(get("/api/teachers/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idTeacher").value(10));
    }

    @Test
    // TODO: 09.10.2020 Нет обработки создания учителей с одинаковой почтой
    public void createTeacherTest() throws Exception {
        this.mockMvc.perform(post("/api/teachers")
                .param("email", "example3@gmail.com")
                .param("firstName", "Петр")
                .param("secondName", "Петров")
                .param("patronymic", "Петрович"))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Teacher was created")));
        this.mockMvc.perform(get("/api/teachers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }
    @Test
    // TODO: 01.12.2020 Нужно добавить @ResponseStatus(HttpStatus.BAD_REQUEST) в исключение
    public void TeacherExistsExceptionTest()throws Exception{
        this.mockMvc.perform(post("/api/teachers")
                .param("email", "example1@gmail.com")
                .param("firstName", "Петр")
                .param("secondName", "Петров")
                .param("patronymic", "Петрович"))
                .andExpect(status().isBadRequest())
                .andExpect(result->assertTrue(result.getResolvedException()instanceof TeacherExistsException));
    }

    @Test
    // TODO: 09.10.2020 Нет обработки изменения почты на существующую
    public void updateTeacherTest() throws Exception {
        this.mockMvc.perform(put("/api/teachers/10")
                .param("firstName", "Андрей")
                .param("secondName", "Андреевич")
                .param("patronymic", "Андреев")
                .param("email", "example3@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Teacher with id '10' updated")));
        this.mockMvc.perform(get("/api/teachers/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("example3@gmail.com"));
    }

    @Test
    public void TeacherNotFoundExceptionTest() throws Exception {
        this.mockMvc.perform(put("/api/teachers/15")
                .param("firstName", "Андрей")
                .param("secondName", "Андреевич")
                .param("patronymic", "Андреев")
                .param("email", "example3@gmail.com"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException() instanceof TeacherNotFoundException));
    }

    @Test
    // TODO: 09.10.2020 Нет возможности удалить из-за зависимости в таблице 
    public void deleteTeacherTest()throws Exception{
        this.mockMvc.perform(delete("/api/teachers/10"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Teacher with id '10' was deleted")));
        this.mockMvc.perform(get("/api/teachers/10"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException() instanceof TeacherNotFoundException));
    }
    @Test
    public void getTeacherSubjectsTest()throws Exception{
        this.mockMvc.perform(get("/api/teachers/10/subjects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].subjects",hasSize(3)));
    }
    @Test
    // TODO: 01.12.2020 ??? насчет добавления одного и того же премета
    public void createSubjectTest()throws Exception{
        this.mockMvc.perform(post("/api/teachers/10/subjects")
                .param("idSubject","13"))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Subject added to idTeacher '10'")));
        this.mockMvc.perform(get("/api/teachers/10/subjects"))
                .andExpect(jsonPath("$[0].subjects",hasSize(4)));
    }
    @Test
    public void SubjectNotFoundException() throws Exception{
        this.mockMvc.perform(post("/api/teachers/10/subjects")
                .param("idSubject","14"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException() instanceof SubjectNotFoundException));
    }
    @Test
    public void getSubjectById() throws Exception{
        this.mockMvc.perform(get("/api/teachers/10/subjects/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.caption").value("first"));
    }
    @Test
    public void deleteTeacherSubjectTest()throws Exception{
        this.mockMvc.perform(delete("/api/teachers/10/subjects/10"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Teacher Subject with id '10' deleted")));
        this.mockMvc.perform(get("/api/teachers/10/subjects/10"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException() instanceof SubjectNotFoundException));
    }
    @Test
    public void TeacherSubjectNotFoundTest() throws  Exception{
        this.mockMvc.perform(delete("/api/teachers/15/subjects/10"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException() instanceof TeacherSubjectNotFound));
    }
    @Test
    public void getGroupsByTeacherTest()throws Exception{
        this.mockMvc.perform(get("/api/teachers/10/groups"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }
    @Test
    public void createTeacherGroupTest()throws Exception{
        this.mockMvc.perform(post("/api/teachers/10/groups")
                .param("idGroup","12"))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Group connected to teacher")));
        this.mockMvc.perform(get("/api/teachers/10/groups"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }

    @Test
    public void GroupNotFoundExceptionTest()throws Exception{
        this.mockMvc.perform(post("/api/teachers/10/groups")
                .param("idGroup","15"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException()instanceof GroupNotFoundException));
    }
    @Test
    // TODO: 14.10.2020 Нет метода поиска группы учителя по id
    public void deleteTeacherGroupTest()throws Exception{
        this.mockMvc.perform(delete("/api/teachers/10/groups/10"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Teacher with id '10' detached from group id '10'")));
        this.mockMvc.perform(get("/api/teachers/10/groups/10"))
                .andExpect(status().isOk())
                .andExpect(result ->assertTrue(result.getResolvedException() instanceof GroupTeacherNotFoundException));
    }

}
