package com.airtribe.SpringBootApplication.controller;

import com.airtribe.SpringBootApplication.entity.Learner;
import com.airtribe.SpringBootApplication.error.LearnerNotFoundException;
import com.airtribe.SpringBootApplication.service.LearnerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LearnerController {

  @Autowired
  private LearnerService learnerService;


  @PostMapping("/learners")
  public Learner createLearner(@Valid @RequestBody Learner learner) {
    return learnerService.createLearner(learner);
  }


  @GetMapping("/learners")
  public List<Learner> getAllLearner() {
    return learnerService.getAllLearners();
  }

  @GetMapping("/learners/{learnerId}")
  public Learner getLearnerById(@PathVariable("learnerId") Long learnerId) throws LearnerNotFoundException {
      return learnerService.getLearnerById(learnerId);
  }

  @PutMapping("/learners/{learnerId}")
  public Learner updateLearner(@PathVariable("learnerId") Long learnerId, @RequestBody Learner learner) {
    return learnerService.updateLearner(learnerId, learner);
  }


  @GetMapping("/learners/name/{learnerName}")
  public List<Learner> fetchLearnersByName(@PathVariable("learnerName") String learnerName) {
    return learnerService.fetchLearnersByName(learnerName);
  }

}
