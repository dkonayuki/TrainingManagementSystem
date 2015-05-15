package com.rakuten.PenguinSoldiers.models.training;

import java.util.List;

public class RegisterUserForm {
  
  private List<Long> out;
  private List<Long> in;
  
  private String trainingId;

  
  public List<Long> getOut() {
    return out;
  }

  public void setOut(List<Long> out) {
    this.out = out;
  }

  public String getTrainingId() {
    return trainingId;
  }

  public void setTrainingId(String trainingId) {
    this.trainingId = trainingId;
  }

  public List<Long> getIn() {
    return in;
  }

  public void setIn(List<Long> in) {
    this.in = in;
  }
  
  
//  public Long getTrainingId() {
//    return trainingId;
//  }
//
//  public void setTrainingId(Long trainingId) {
//    this.trainingId = trainingId;
//  }
  
  
  
  
  
}
