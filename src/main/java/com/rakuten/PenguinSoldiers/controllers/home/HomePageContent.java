package com.rakuten.PenguinSoldiers.controllers.home;

public class HomePageContent {
  

  private String trainingTab="";
  
  public static String TRAINING_TAB_IN="in";
  public static String TRAINING_TAB_OUT="out";
  
  public String getTrainingTab() {
    return trainingTab;
  }
  public void setTrainingTab(String trainingTab) {
    this.trainingTab = trainingTab;
  }
  
  public boolean isActiveTrainingTab(String label){
    return this.getTrainingTab().equals(label);
  }
  
  public String showActiveTrainingTab(String label){
    return this.isActiveTrainingTab(label) ? "active" : "";
  }
  
  
}
