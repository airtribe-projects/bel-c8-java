package com.airtribe.SpringBootApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.List;


@Entity
public class Learner {
  @NotBlank(message = "Name is mandatory")
  private String learnerName;


  @Positive(message = "Age should be positive")
  private int age;

  @Email
  private String email;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long learnerId;

  @ManyToMany(mappedBy = "_learnerList")
  @JsonBackReference
  private List<Cohort> _cohortList;

  public Learner(String learnerName, int age, String email, long learnerId) {
    this.learnerName = learnerName;
    this.age = age;
    this.email = email;
    this.learnerId = learnerId;
  }

  public Learner() {
  }

  public String getLearnerName() {
    return learnerName;
  }

  public void setLearnerName(String learnerName) {
    this.learnerName = learnerName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getLearnerId() {
    return learnerId;
  }

  public void setLearnerId(long learnerId) {
    this.learnerId = learnerId;
  }
}
