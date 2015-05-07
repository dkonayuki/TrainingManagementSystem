package com.rakuten.PenguinSoldiers.entity;

public class TrainingGoal {
  private Long id;
  private Training training;
  private String goal;
  
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Training getTraining() {
    return training;
  }
  public void setTraining(Training training) {
    this.training = training;
  }
  public String getGoal() {
    return goal;
  }
  public void setGoal(String goal) {
    this.goal = goal;
  }
  
  
  
}
