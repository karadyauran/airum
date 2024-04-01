package com.karadyauran.airum.web;

import com.karadyauran.airum.dto.UserRegistrationDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
class UserControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.2")
            .withInitScript("create.sql");

    @BeforeAll
    static void setUp()
    {
        postgres.start();
    }

    @AfterAll
    static void tearDown()
    {
        postgres.stop();
    }


    @Test
    public void testGetById() throws Exception
    {
        String userId = "14b75de4-c006-445a-b131-7ffa477d7665";

        mockMvc.perform(MockMvcRequestBuilders.get("/user/" + userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(userId)));
    }

    @Test
    public void testGetByUsername() throws Exception
    {
        String username = "milton.pfeffer";

        mockMvc.perform(MockMvcRequestBuilders.get("/" + username))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(username)));
    }

    @Test
    public void testGetAll() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testChangeUsername() throws Exception
    {
        String userId = "14b75de4-c006-445a-b131-7ffa477d7665";
        String newUsername = "iurtyeiutyiewurt";

        mockMvc.perform(MockMvcRequestBuilders.put("/user/change-username")
                        .param("id", userId)
                        .param("username", newUsername)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("iurtyeiutyiewurt")));
    }

    @Test
    public void testChangeFirstname() throws Exception
    {
        String userId = "14b75de4-c006-445a-b131-7ffa477d7665";
        String newFirstname = "HelloWorld";

        mockMvc.perform(MockMvcRequestBuilders.put("/user/change-firstname")
                        .param("id", userId)
                        .param("firstname", newFirstname)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("HelloWorld")));
    }

    @Test
    public void testChangeSurname() throws Exception
    {
        String userId = "14b75de4-c006-445a-b131-7ffa477d7665";
        String newSurname = "Lalala";

        mockMvc.perform(MockMvcRequestBuilders.put("/user/change-surname")
                        .param("id", userId)
                        .param("surname", newSurname)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Lalala")));
    }

    @Test
    public void testChangeEmail() throws Exception
    {
        String userId = "14b75de4-c006-445a-b131-7ffa477d7665";
        String newEmail = "oououououo@gmail.com";

        mockMvc.perform(MockMvcRequestBuilders.put("/user/change-email")
                        .param("id", userId)
                        .param("email", newEmail)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("oououououo@gmail.com")));
    }

    @Test
    public void testDelete() throws Exception
    {
        String userId = "7dc91392-0dce-45e8-b3a8-c4e711b2f45f";

        mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete/" + userId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(not(containsString(userId))));
    }

    @Test
    public void testCreate() throws Exception
    {
        var user = UserRegistrationDto.builder()
                .username("user123")
                .firstname("boom")
                .surname("bim")
                .email("lalalalalala@gmail.com")
                .password("$2a$10$hEy85MmWmo1rKR.IHS36y.qYQgFIMqrcWY26lQegqlFdvge7RLmjO")
                .build();

        var m = new ObjectMapper();
        var obj = m.writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(obj))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
