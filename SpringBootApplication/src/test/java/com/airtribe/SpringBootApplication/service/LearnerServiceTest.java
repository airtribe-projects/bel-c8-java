package com.airtribe.SpringBootApplication.service;

import com.airtribe.SpringBootApplication.entity.Learner;
import com.airtribe.SpringBootApplication.error.LearnerNotFoundException;
import com.airtribe.SpringBootApplication.repository.LearnerRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class LearnerServiceTest {

  public LearnerServiceTest() {

  }

  @Autowired
  private LearnerService _learnerService;

  @MockBean
  private LearnerRepository _learnerRepository;


  @BeforeAll
  static void beforeAll() {
    System.out.println("Setting up once");
  }

  @BeforeEach
  void setUp() {
    System.out.println("Setting up");
    Learner learner = new Learner("John", 25, "test@gmail.com", 1L);

    when(_learnerRepository.findById(1L)).thenReturn(Optional.of(learner));
    when(_learnerRepository.findById(2L)).thenReturn(Optional.empty());
  }

  @Test
  void fetchLearnerByIdtest() throws LearnerNotFoundException {

    Learner learner1 = _learnerService.getLearnerById(1L);
    assertEquals(1L, learner1.getLearnerId());
    assertEquals("John", learner1.getLearnerName());
    assertEquals(25, learner1.getAge());
    assertEquals("test@gmail.com", learner1.getEmail());
  }
  //Anatomy of unit test

  @Test
  @DisplayName("Test fetch learner by id for exception")
  void fetchLearnerDoesNotExist() {
    assertThrows(LearnerNotFoundException.class, () -> _learnerService.getLearnerById(2L));
  }
}