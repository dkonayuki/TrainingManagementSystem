package com.rakuten.PenguinSoldiers.entity;

public class TrainingCondition {
  
  private Long id;
  private Training training;
  private String condition;
  
  
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
  public String getCondition() {
    return condition;
  }
  public void setCondition(String condition) {
    this.condition = condition;
  }
  
  
}
