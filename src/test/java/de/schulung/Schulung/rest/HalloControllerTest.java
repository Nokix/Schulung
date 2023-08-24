package de.schulung.Schulung.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HalloController.class)
@ComponentScan(basePackages = "de.schulung.Schulung")
class HalloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCountUp1() throws Exception {
        String expected = "4 5 6 7";

        var getRequest = MockMvcRequestBuilders
                .get("/count")
                .param("n", "7")
                .param("start", "4");

        mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }
}