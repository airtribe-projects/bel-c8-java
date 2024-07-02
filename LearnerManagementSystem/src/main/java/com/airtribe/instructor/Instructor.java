package com.airtribe.instructor;

public class Instructor {
  private String instructorName;
  private String instructorId;
  private String instructorEmail;
  private String instructorPhone;
  private long instructorExperience;

  public Instructor(String instructorName, String instructorId, String instructorEmail, String instructorPhone, long instructorExperience) {
    this.instructorName = instructorName;
    this.instructorId = instructorId;
    this.instructorEmail = instructorEmail;
    this.instructorPhone = instructorPhone;
    this.instructorExperience = instructorExperience;
  }

  @Override
  public String toString() {
    return "Instructor{" + "instructorName='" + instructorName + '\'' + ", instructorId='" + instructorId + '\''
        + ", instructorEmail='" + instructorEmail + '\'' + ", instructorPhone='" + instructorPhone + '\''
        + ", instructorExperience=" + instructorExperience + '}';
  }

  public String getInstructorName() {
    return instructorName;
  }

  public void setInstructorName(String instructorName) {
    this.instructorName = instructorName;
  }

  public String getInstructorId() {
    return instructorId;
  }

  public void setInstructorId(String instructorId) {
    this.instructorId = instructorId;
  }

  public String getInstructorEmail() {
    return instructorEmail;
  }

  public void setInstructorEmail(String instructorEmail) {
    this.instructorEmail = instructorEmail;
  }

  public String getInstructorPhone() {
    return instructorPhone;
  }

  public void setInstructorPhone(String instructorPhone) {
    this.instructorPhone = instructorPhone;
  }

  public long getInstructorExperience() {
    return instructorExperience;
  }

  public void setInstructorExperience(long instructorExperience) {
    this.instructorExperience = instructorExperience;
  }
}
