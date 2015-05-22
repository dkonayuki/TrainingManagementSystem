package com.rakuten.PenguinSoldiers.controllers.training;

import java.util.List;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.training.Training;

public class TrainingUserManageContent {
  
  private List<Account> in;
  private List<Account> out;
  
  private Training training;

  public List<Account> getIn() {
    return in;
  }

  public void setIn(List<Account> in) {
    this.in = in;
  }

  public List<Account> getOut() {
    return out;
  }

  public void setOut(List<Account> out) {
    this.out = out;
  }

  public Training getTraining() {
    return training;
  }

  public void setTraining(Training training) {
    this.training = training;
  }
  
  

}
