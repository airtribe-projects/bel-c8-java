package com.airtribe.SpringBootApplication.controller;

import com.airtribe.SpringBootApplication.entity.Cohort;
import com.airtribe.SpringBootApplication.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CohortController {

  @Autowired
  private LearnerService _learnerService;

  @PostMapping("/cohorts")
  public Cohort createCohort(@RequestBody Cohort cohort) {
    return _learnerService.createCohort(cohort);
  }

  @PostMapping("/assign")
  public Cohort assignLearner(@RequestParam("learnerId") Long learnerId, @RequestParam("cohortId") Long cohortId) {
    return _learnerService.assignLearner(learnerId, cohortId);
  }
}
