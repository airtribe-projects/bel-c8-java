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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
  private List<Cohort> _cohortList;

  public Learner(String learnerName, int age, String email, Long learnerId) {
    this.learnerName = learnerName;
    this.age = age;
    this.email = email;
    this.learnerId = learnerId;
  }

}
