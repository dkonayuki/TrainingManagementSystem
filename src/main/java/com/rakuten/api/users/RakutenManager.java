package com.rakuten.api.users;

import java.util.List;

public class RakutenManager {
  
  private String username;
  private List<String> employees;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getEmployees() {
    return employees;
  }

  public void setEmployees(List<String> employees) {
    this.employees = employees;
  }
  
  
}
