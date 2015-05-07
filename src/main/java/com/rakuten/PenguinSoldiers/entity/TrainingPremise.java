package com.rakuten.PenguinSoldiers.entity;

public class TrainingPremise {
  
  private Long id;
  private Training training;
  private String content;
  
  
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
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  
  
}
