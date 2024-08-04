package com.airtribe.SpringBootApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;


@Entity
public class Cohort {


  private String cohortName;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long cohortId;

  @ManyToMany
  private List<Learner> _learnerList;

  public Cohort(String cohortName, List<Learner> learnerList) {
    this.cohortName = cohortName;
    this._learnerList = learnerList;
  }

  public Cohort() {

  }

  public String getCohortName() {
    return cohortName;
  }

  public void setCohortName(String cohortName) {
    this.cohortName = cohortName;
  }

  public long getCohortId() {
    return cohortId;
  }

  public void setCohortId(long cohortId) {
    this.cohortId = cohortId;
  }

  public List<Learner> getLearnerList() {
    return _learnerList;
  }

  public void setLearnerList(List<Learner> learnerList) {
    _learnerList = learnerList;
  }
}
