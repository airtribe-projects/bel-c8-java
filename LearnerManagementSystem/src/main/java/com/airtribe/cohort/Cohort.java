package com.airtribe.cohort;

import com.airtribe.instructor.Instructor;
import com.airtribe.learner.Learner;
import java.util.List;


public class Cohort {
  private String cohortId;
  private String startDate;
  private String endDate;
  private String cohortName;
  private String cohortDescription;
  private List<Learner> learners;
  private List<Instructor> instructors;

  public String getCohortName() {
    return cohortName;
  }

  public void setCohortName(String cohortName) {
    this.cohortName = cohortName;
  }

  public String getCohortDescription() {
    return cohortDescription;
  }

  public void setCohortDescription(String cohortDescription) {
    this.cohortDescription = cohortDescription;
  }


  public Cohort(String cohortId, String startDate, String endDate, String cohortName, String cohortDescription,
      List<Learner> learners, List<Instructor> instructors) {
    this.cohortId = cohortId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.cohortName = cohortName;
    this.cohortDescription = cohortDescription;
    this.learners = learners;
    this.instructors = instructors;
  }

  public String getCohortId() {
    return cohortId;
  }

  public void setCohortId(String cohortId) {
    this.cohortId = cohortId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public List<Learner> getLearners() {
    return learners;
  }

  public void setLearners(List<Learner> learners) {
    this.learners = learners;
  }

  public List<Instructor> getInstructors() {
    return instructors;
  }

  public void setInstructors(List<Instructor> instructors) {
    this.instructors = instructors;
  }

  public void enrollLearner(Learner learner) {
    learners.add(learner);
  }

  public void removeLearner(Learner learner) {
    learners.remove(learner);
  }

  public double calculateAverageXp() {
    int totalXp = 0;
    for (Learner learner : learners) {
      totalXp += learner.getXp();
    }
    return (double) totalXp / (double) learners.size();
  }

  public void displayCohortDetails() {
    System.out.println("Cohort Details:");
    System.out.println("---------------");
    System.out.println("Cohort ID: " + cohortId);
    System.out.println("Start Date: " + startDate);
    System.out.println("End Date: " + endDate);
    System.out.println("Cohort Name: " + cohortName);
    System.out.println("Cohort Description: " + cohortDescription);
    System.out.println("---------------");
    System.out.println("Learners:");
    System.out.println("---------------");
    for (Learner learner : learners) {
      System.out.println("Learner ID: " + learner.getLearnerId());
      System.out.println("Learner Name: " + learner.getLearnerName());
      System.out.println("Learner XP: " + learner.getXp());
      System.out.println("---------------");
    }
    System.out.println("Instructors:");
    System.out.println("---------------");
    for (Instructor instructor : instructors) {
      System.out.println("Instructor ID: " + instructor.getInstructorId());
      System.out.println("Instructor Name: " + instructor.getInstructorName());
      System.out.println("Instructor Email: " + instructor.getInstructorEmail());
      System.out.println("Instructor Phone: " + instructor.getInstructorPhone());
      System.out.println("Instructor Experience: " + instructor.getInstructorExperience());
      System.out.println("---------------");
    }
  }
}
