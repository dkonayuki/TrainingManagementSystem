package com.rakuten.PenguinSoldiers.controllers.home;

import com.rakuten.PenguinSoldiers.models.account.Account;

public class HeaderPageContent {
  
  private boolean isAdmin,isManager;

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
}
