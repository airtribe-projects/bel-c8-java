package com.airtribe.learner;

public class JavaLearner extends Learner {
  private int javaExperience;
  private int javaProjects;

  public JavaLearner(String learnerId, String learnerName, int xp, int javaExperience, int javaProjects) {
    super(learnerId, learnerName, xp);
    this.javaExperience = javaExperience;
    this.javaProjects = javaProjects;
  }

  @Override
  public void displayLearnerDetails() {
    System.out.println("JavaLearner{" + "learnerId='" + learnerId + '\'' + ", learnerName='" + learnerName + '\'' + ", xp=" + xp + ", javaExperience=" + javaExperience + ", javaProjects=" + javaProjects + '}');
  }
}
