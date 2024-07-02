package com.airtribe.learner;

public abstract class Learner {
  protected String learnerId;
  protected String learnerName;
  protected int xp;

  public Learner(String learnerId, String learnerName, int xp) {
    this.learnerId = learnerId;
    this.learnerName = learnerName;
    this.xp = xp;
  }

  public Learner(String learnerId, String learnerName) {
    this.learnerId = learnerId;
    this.learnerName = learnerName;
    this.xp = 0;
  }

  public String getLearnerId() {
    return learnerId;
  }

  public void setLearnerId(String learnerId) {
    this.learnerId = learnerId;
  }

  public String getLearnerName() {
    return learnerName;
  }

  public void setLearnerName(String learnerName) {
    this.learnerName = learnerName;
  }

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

  @Override
  public String toString() {
    return "Learner{" + "learnerId='" + learnerId + '\'' + ", learnerName='" + learnerName + '\'' + ", xp=" + xp + '}';
  }

  public abstract void displayLearnerDetails();
}
