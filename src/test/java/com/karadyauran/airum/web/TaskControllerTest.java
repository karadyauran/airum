package com.karadyauran.airum.web;

import com.karadyauran.airum.dto.TaskDto;
import com.karadyauran.airum.dto.UserRegistrationDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
class TaskControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.2")
            .withInitScript("create.sql");

    @BeforeAll
    static void setUp() {
        postgres.start();
    }

    @AfterAll
    static void tearDown() {
        postgres.stop();
    }

    @Test
    public void testGetById() throws Exception
    {
        String taskId = "86036cd8-4fbc-4dab-8f74-ec4cc82df6a4";

        mockMvc.perform(MockMvcRequestBuilders.get("/task/" + taskId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(taskId)));
    }

    @Test
    public void testGetByProject() throws Exception
    {
        String projectId = "8ec8eaf0-b1de-4f4b-8715-64b2959bffd2";
        String taskIncluded = "fd9e86b6-b89d-42bf-badf-610c3ccd7bb2";

        mockMvc.perform(MockMvcRequestBuilders.get("/task/project")
                        .param("id", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(taskIncluded)));
    }

    @Test
    public void testGetByProjectAndStatus() throws Exception
    {
        String projectId = "34c5773b-0a9b-40c3-988e-e8f3a530c8c5";
        String status = "IN_PROGRESS";
        String taskIncluded = "bcb89d6c-edbf-49fc-83e0-cb104dfe76b3";

        mockMvc.perform(MockMvcRequestBuilders.get("/task/status")
                        .param("id", projectId)
                        .param("status", status)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(taskIncluded)));
    }

    @Test
    public void testChangeTitle() throws Exception
    {
        String taskId = "51563fe9-4510-405e-9eaf-b3a573e860b5";
        String newTitle = "New title";

        mockMvc.perform(MockMvcRequestBuilders.put("/task/change-title")
                        .param("id", taskId)
                        .param("newTitle", newTitle)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(newTitle)));
    }

    @Test
    public void testChangeDescription() throws Exception
    {
        String taskId = "51563fe9-4510-405e-9eaf-b3a573e860b5";
        String newDescription = "New Description";

        mockMvc.perform(MockMvcRequestBuilders.put("/task/change-description")
                        .param("id", taskId)
                        .param("newDescription", newDescription)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(newDescription)));
    }

    @Test
    public void testAssignToUser() throws Exception
    {
        String taskId = "51563fe9-4510-405e-9eaf-b3a573e860b5";
        String userId = "e3ea02ff-2e76-49be-8598-18f2495a8946";

        mockMvc.perform(MockMvcRequestBuilders.put("/task/assign-to-user")
                        .param("id", taskId)
                        .param("user", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(userId)));
    }

    @Test
    public void testChangeDate() throws Exception
    {
        String taskId = "51563fe9-4510-405e-9eaf-b3a573e860b5";
        String newDate = "2024-04-28T12:00:00";

        mockMvc.perform(MockMvcRequestBuilders.put("/task/change-date")
                        .param("id", taskId)
                        .param("newDate", newDate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("2024-04-27T22:00:00.000+00:00")));
    }

    @Test
    public void testDelete() throws Exception
    {
        String taskId = "7171064d-2d76-4b37-9278-6edebcb141b2";

        mockMvc.perform(MockMvcRequestBuilders.delete("/task/delete")
                        .param("id", taskId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/task/" + taskId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testCreate() throws Exception
    {
        var task = TaskDto.builder()
                .title("Title")
                .description("Description");

        var m = new ObjectMapper();
        var obj = m.writeValueAsString(task);

        mockMvc.perform(MockMvcRequestBuilders.post("/task/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(obj))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}