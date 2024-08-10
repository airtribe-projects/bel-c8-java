package com.airtribe.SpringBootApplication.controller;

import com.airtribe.SpringBootApplication.entity.Learner;
import com.airtribe.SpringBootApplication.service.LearnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(LearnerController.class)
class LearnerControllerTest {

  @MockBean
  private LearnerService _learnerService;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
  }

  @Test
  void createLearner() throws Exception {

    Learner learner = new Learner();
    learner.setLearnerName("John");
    learner.setAge(25);
    learner.setEmail("test@gmail.com");

    String learnerJson = "{\"email\":\"test@example.com\",\"age\":32, \"learnerName\": \"test\"}";

    when(_learnerService.createLearner(any(Learner.class))).thenReturn(learner);
    mockMvc.perform(MockMvcRequestBuilders.post("/learners").contentType(MediaType.APPLICATION_JSON).content(learnerJson))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.learnerName").value("John"));

  }
}