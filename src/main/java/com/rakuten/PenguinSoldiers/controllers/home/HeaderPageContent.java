package com.rakuten.PenguinSoldiers.controllers.home;

import com.rakuten.PenguinSoldiers.models.account.Account;

public class HeaderPageContent {
  
  private boolean isAdmin=false,isManager=false;
  
  public static String HOME_LABEL="home";
  public static String TRAINING_LABEL="training";
  public static String ACCOUNT_LABEL="account";
  public static String MODE_LABEL="mode";
  
  private String activeLabel="";
  
  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public boolean isManager() {
    return isManager;
  }

  public void setManager(boolean isManager) {
    this.isManager = isManager;
  }
  
  public void setActiveLabel(String label){
    this.activeLabel=label;
  }
  
  public String getActiveLabel(){
    return this.activeLabel;
  }
  
  public boolean isActiveLabel(String label){
    return this.getActiveLabel().equals(label);
  }
  
  public String showActiveLabel(String label){
    return this.isActiveLabel(label) ? "active" : "";
  }
}
