package com.airtribe.course;

import com.airtribe.cohort.Cohort;
import java.util.ArrayList;


public class OnlineCourse extends Course {

  private String zoomUrl;

  public OnlineCourse(String courseId, String courseName, String courseDescription, CourseType courseType, String zoomUrl) {
    super(courseId, courseName, courseDescription, courseType);
    this.zoomUrl = zoomUrl;
    super.cohorts = new ArrayList<>();
  }

  public String getZoomUrl() {
    return zoomUrl;
  }

  public void setZoomUrl(String zoomUrl) {
    this.zoomUrl = zoomUrl;
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
    System.out.println("-------------------------------");
    System.out.println("Course ID: " + courseId);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Description: " + courseDescription);
    System.out.println("Course Type: " + courseType);
    System.out.println("Zoom URL: " + zoomUrl);
    System.out.println("Cohorts: ");
    for (Cohort cohort : cohorts) {
      System.out.println("Cohort ID: " + cohort.getCohortId());
      System.out.println("Cohort Name: " + cohort.getCohortName());
      System.out.println("Cohort Description: " + cohort.getCohortDescription());
      System.out.println("Cohort Start Date: " + cohort.getStartDate());
      System.out.println("Cohort End Date: " + cohort.getEndDate());
    }
    System.out.println("-------------------------------");
  }
}
