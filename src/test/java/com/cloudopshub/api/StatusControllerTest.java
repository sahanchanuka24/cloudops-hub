package com.cloudopshub.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class StatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHealthyApiStatus() throws Exception {
        mockMvc.perform(get("/api/v1/status"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("CloudOps Hub")))
                .andExpect(content().string(containsString("UP")));
    }
}
