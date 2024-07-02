package com.airtribe.course;

import com.airtribe.cohort.Cohort;
import java.util.List;


public abstract class Course {
  protected String courseId;
  protected String courseName;
  protected String courseDescription;
  protected List<Cohort> cohorts;
  protected CourseType courseType;

  public Course(String courseId, String courseName, String courseDescription, List<Cohort> cohorts,
      CourseType courseType) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.cohorts = cohorts;
    this.courseType = courseType;
  }

  public Course(String courseId, String courseName, String courseDescription, CourseType courseType) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.courseType = courseType;
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseDescription() {
    return courseDescription;
  }

  public void setCourseDescription(String courseDescription) {
    this.courseDescription = courseDescription;
  }

  public List<Cohort> getCohorts() {
    return cohorts;
  }

  public void setCohorts(List<Cohort> cohorts) {
    this.cohorts = cohorts;
  }

  public CourseType getCourseType() {
    return courseType;
  }

  public void setCourseType(CourseType courseType) {
    this.courseType = courseType;
  }

  public abstract void addCohort(Cohort cohort);

  public abstract void removeCohort(Cohort cohort);

  public abstract void displayCourseDetails();
}
