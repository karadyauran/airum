package com.karadyauran.airum.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karadyauran.airum.dto.ProjectDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Testcontainers
@AutoConfigureMockMvc
class ProjectControllerTest
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
    public void testGetProjectById() throws Exception
    {
        String projectId = "8ec8eaf0-b1de-4f4b-8715-64b2959bffd2";
        mockMvc.perform(get("/project")
                        .param("id", projectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(projectId));
    }

    @Test
    public void testGetAllProjects() throws Exception
    {
        String userId = "e3ea02ff-2e76-49be-8598-18f2495a8946";
        mockMvc.perform(get("/projects")
                        .param("userId", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateProject() throws Exception
    {
        String projectId = "34c5773b-0a9b-40c3-988e-e8f3a530c8c5";
        String newProjectName = "Updated Project Name";
        mockMvc.perform(put("/project/change-name")
                        .param("id", projectId)
                        .param("newName", newProjectName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(newProjectName));
    }

    @Test
    public void testDeleteProject() throws Exception
    {
        String projectId = "34c5773b-0a9b-40c3-988e-e8f3a530c8c5";
        mockMvc.perform(delete("/project/delete/" + projectId))
                .andExpect(status().isOk());
    }
}
