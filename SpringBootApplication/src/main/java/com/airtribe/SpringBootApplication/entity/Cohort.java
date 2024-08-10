package com.airtribe.SpringBootApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;


@Entity
public class Cohort {


  private String cohortName;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long cohortId;

  @ManyToMany
  @JoinTable(
      name = "cohort_learner",
      joinColumns = @JoinColumn(name = "cohort_id"),
      inverseJoinColumns = @JoinColumn(name = "learner_id")
  )
  private List<Learner> _learnerList;


  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;


  @ManyToMany
  @JoinTable(
      name = "cohort_instructor",
      joinColumns = @JoinColumn(name = "cohort_id"),
      inverseJoinColumns = @JoinColumn(name = "instructor_id")
  )
  private List<Instructor> _instructorList;

  public Cohort(String cohortName, List<Learner> learnerList) {
    this.cohortName = cohortName;
    this._learnerList = learnerList;
  }

  public Cohort(String cohortName, long cohortId, List<Learner> learnerList, Course course,
      List<Instructor> instructorList) {
    this.cohortName = cohortName;
    this.cohortId = cohortId;
    _learnerList = learnerList;
    this.course = course;
    _instructorList = instructorList;
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
