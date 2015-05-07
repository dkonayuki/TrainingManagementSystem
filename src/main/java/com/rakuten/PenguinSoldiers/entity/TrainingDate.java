package com.rakuten.PenguinSoldiers.entity;

import java.sql.Timestamp;

public class TrainingDate {
  
  private Long id;
  private Training training;
  private Timestamp date;
  
  
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
  public Timestamp getDate() {
    return date;
  }
  public void setDate(Timestamp date) {
    this.date = date;
  }
  
  
}
