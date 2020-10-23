package crutchesbicycles.studyhelper;

import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.GroupMaterialNotFoundException;
import crutchesbicycles.studyhelper.exception.GroupNotFoundException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
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
@Sql(value = {"/create-groupmaterial-before.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-groupmaterial-after.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class GroupMaterialControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    // TODO: 14.10.2020 Нет конструктора без параметров в GroupMaterials
    public void getGroupMaterialTest()throws Exception{
        this.mockMvc.perform(get("/api/groups/10/materials"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)));
    }

    @Test
    public void GroupNotFoundExceptionTest() throws Exception{
        this.mockMvc.perform(get("/api/groups/15/materials"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException() instanceof GroupNotFoundException));
    }

    @Test
    // TODO: 14.10.2020 Нет унификации, в одном месте material в URL,в другом materials
    public void getGroupMaterialByIdTest()throws Exception{
        this.mockMvc.perform(get("/api/groups/10/materials/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.file").value("exampleFile1"));
    }

    @Test
    public void GroupMaterialNotFoundExceptionTest()throws Exception{
        this.mockMvc.perform(get("/api/groups/10/materials/15"))
                .andExpect(status().isNotFound())
                .andExpect(result->assertTrue(result.getResolvedException()instanceof GroupMaterialNotFoundException));
    }
}
