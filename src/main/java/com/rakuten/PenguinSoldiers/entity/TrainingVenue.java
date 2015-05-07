package com.rakuten.PenguinSoldiers.entity;

public class TrainingVenue {
  
  private Long id;
  private Training training;
  private String venue;
  
  
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
  public String getVenue() {
    return venue;
  }
  public void setVenue(String venue) {
    this.venue = venue;
  }
  
  
}
