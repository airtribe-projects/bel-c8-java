package com.airtribe.SpringBootApplication.repository;

import com.airtribe.SpringBootApplication.entity.Learner;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
class LearnerRepositoryTest {

  @Autowired
  private LearnerRepository _learnerRepository;

  @Autowired
  private TestEntityManager _entityManager;

  @BeforeEach
  void setUp() {
    Learner learner = new Learner();
    learner.setLearnerName("John");
    learner.setAge(25);
    learner.setEmail("test@gmail.com");
    _entityManager.persist(learner);
  }

  @AfterEach
  void cleanup() {
    _entityManager.clear();
  }


  @Test
  void findById() {
    Learner learner = _learnerRepository.findById(1L).get();
    assertEquals(1L, learner.getLearnerId());
  }

  @Test
  void findByIdDoesNotExist() {
    Optional<Learner> learnerOptional = _learnerRepository.findById(2L);
    assertFalse(learnerOptional.isPresent());
  }
}