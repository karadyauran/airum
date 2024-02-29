package com.karadyauran.airum.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karadyauran.airum.entity.Notification;
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
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Testcontainers
@AutoConfigureMockMvc
public class NotificationControllerTest
{

    @Autowired
    private MockMvc mockMvc;

    @Container
    @ServiceConnection
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.2")
            .withInitScript("create.sql");

    private static final ObjectMapper objectMapper = new ObjectMapper();

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
    public void testGetNotifications() throws Exception
    {
        String user1 = "c23ebbb0-4d47-42b3-982b-0b963d917a25";
        String user2 = "7dc91392-0dce-45e8-b3a8-c4e711b2f45f";

        mockMvc.perform(get("/chat")
                        .param("user1", user1)
                        .param("user2", user2))
                .andExpect(status().isOk());
    }

    @Test
    public void testSendNotification() throws Exception
    {
        var notification = new Notification();
        notification.setReceiver(UUID.fromString("7dc91392-0dce-45e8-b3a8-c4e711b2f45f"));
        notification.setSender(UUID.fromString("c23ebbb0-4d47-42b3-982b-0b963d917a25"));
        notification.setMessage("hello!!!");
        notification.setSentAt(Timestamp.from(Instant.now()));

        String notificationJson = objectMapper.writeValueAsString(notification);

        mockMvc.perform(post("/chat/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(notificationJson))
                .andExpect(status().isOk());
    }
}
