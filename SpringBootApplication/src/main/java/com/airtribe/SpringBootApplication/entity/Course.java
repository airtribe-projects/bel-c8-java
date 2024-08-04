package com.airtribe.SpringBootApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long courseId;

  private String name;

  private String description;

  @OneToMany(mappedBy = "course")
  private List<Cohort> cohortList;

  public Course(Long courseId, String name, String description, List<Cohort> cohortList) {
    this.courseId = courseId;
    this.name = name;
    this.description = description;
    this.cohortList = cohortList;
  }

  public Course() {

  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Cohort> getCohortList() {
    return cohortList;
  }

  public void setCohortList(List<Cohort> cohortList) {
    this.cohortList = cohortList;
  }
}
