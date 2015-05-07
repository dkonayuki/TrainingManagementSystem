package com.rakuten.PenguinSoldiers.entity;

public class TrainingTarget {
  
  private Long id;
  private Training training;
  private String target;
  
  
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
  public String getTarget() {
    return target;
  }
  public void setTarget(String target) {
    this.target = target;
  }
  
  

}
