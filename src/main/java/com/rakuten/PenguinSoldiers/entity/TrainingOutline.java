package com.rakuten.PenguinSoldiers.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class TrainingOutline {
  
  private Long id;
  private Training training;
  private String content;
  private Date date;
  
  
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
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  
  
}
