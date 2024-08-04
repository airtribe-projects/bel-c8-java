package com.airtribe.SpringBootApplication.service;

import com.airtribe.SpringBootApplication.entity.Cohort;
import com.airtribe.SpringBootApplication.entity.Learner;
import com.airtribe.SpringBootApplication.error.LearnerNotFoundException;
import com.airtribe.SpringBootApplication.repository.CohortRepository;
import com.airtribe.SpringBootApplication.repository.LearnerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LearnerService {

  @Autowired
  private LearnerRepository learnerRepository;

  @Autowired
  private CohortRepository cohortRepository;

  public List<Learner> getAllLearners() {
    return learnerRepository.findAll();
  }

  public Learner createLearner(Learner learner) {
    return learnerRepository.save(learner);
  }

  public Learner getLearnerById(Long learnerId) throws LearnerNotFoundException {
    Optional<Learner> learnerOptional = learnerRepository.findById(learnerId);
    if(learnerOptional.isPresent()) {
      return learnerOptional.get();
    } else {
      throw new LearnerNotFoundException("Learner not found");
    }
  }

  public Learner updateLearner(Long learnerId, Learner learner) {
    Learner originalLearner = learnerRepository.findById(learnerId).get();
    originalLearner.setAge(learner.getAge());
    originalLearner.setLearnerName(learner.getLearnerName());
    originalLearner.setEmail(learner.getEmail());
    learnerRepository.save(originalLearner);
    return originalLearner;
  }

  public List<Learner> fetchLearnersByName(String learnerName) {
    return learnerRepository.findByLearnerName(learnerName);
  }

  public Cohort createCohort(Cohort cohort) {
    return cohortRepository.save(cohort);
  }

  public Cohort assignLearner(Long learnerId, Long cohortId) {
    Learner learner = learnerRepository.findById(learnerId).get();
    Cohort cohort = cohortRepository.findById(cohortId).get();
    cohort.getLearnerList().add(learner);
    cohortRepository.save(cohort);
    return cohort;
  }
}
