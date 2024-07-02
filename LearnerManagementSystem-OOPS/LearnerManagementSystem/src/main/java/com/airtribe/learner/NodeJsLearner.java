package com.airtribe.learner;

public class NodeJsLearner extends Learner{
  private int nodeJsExperience;
  private int nodeJsProjects;

  public NodeJsLearner(String learnerId, String learnerName, int xp, int nodeJsExperience, int nodeJsProjects) {
    super(learnerId, learnerName, xp);
    this.nodeJsExperience = nodeJsExperience;
    this.nodeJsProjects = nodeJsProjects;
  }

  @Override
  public void displayLearnerDetails() {
    System.out.println("NodeJsLearner{" + "learnerId='" + learnerId + '\'' + ", learnerName='" + learnerName + '\'' + ", xp=" + xp + ", nodeJsExperience=" + nodeJsExperience + ", nodeJsProjects=" + nodeJsProjects + '}');
  }
}
