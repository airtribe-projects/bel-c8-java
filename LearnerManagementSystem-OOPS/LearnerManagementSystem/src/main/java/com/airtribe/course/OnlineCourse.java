package com.airtribe.course;

import com.airtribe.cohort.Cohort;
import java.util.ArrayList;


public class OnlineCourse extends Course {

  public OnlineCourse(String courseId, String courseName, String courseDescription, CourseType courseType) {
    super(courseId, courseName, courseDescription, courseType);
    super.cohorts = new ArrayList<>();
  }

  @Override
  public void addCohort(Cohort cohort) {
      cohorts.add(cohort);
  }

  @Override
  public void removeCohort(Cohort cohort) {
      cohorts.remove(cohort);
  }

  @Override
  public void displayCourseDetails() {
    System.out.println("Course ID: " + courseId);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Description: " + courseDescription);
    System.out.println("Course Type: " + courseType);
    System.out.println("Cohorts: ");
    for (Cohort cohort : cohorts) {
      System.out.println("Cohort ID: " + cohort.getCohortId());
      System.out.println("Cohort Name: " + cohort.getCohortName());
      System.out.println("Cohort Description: " + cohort.getCohortDescription());
      System.out.println("Cohort Start Date: " + cohort.getStartDate());
      System.out.println("Cohort End Date: " + cohort.getEndDate());
    }
  }
}
