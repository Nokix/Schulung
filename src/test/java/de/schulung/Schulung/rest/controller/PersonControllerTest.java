package de.schulung.Schulung.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.schulung.Schulung.rest.entity.Person;
import de.schulung.Schulung.rest.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void findAll() {

    }

    @Test
    void saveNewPerson() throws Exception {
        Person inputPerson = Person.builder().lastName("Ma").firstName("Jun").build();
        Person outputPerson = Person.builder().lastName("Ma").firstName("Jun").id(1L).build();

        Mockito.when(personService.save(inputPerson)).thenReturn(outputPerson);

        String inputPersonJson = objectMapper.writeValueAsString(inputPerson);
        String outputPersonJson = objectMapper.writeValueAsString(outputPerson);

        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputPersonJson);

        mockMvc.perform(post)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(outputPersonJson));
    }
}