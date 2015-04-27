package com.rakuten.PenguinSoldiers.entity;

public class User {
  
  public Long id;
  public String name;
  public String email;
  public String password;
  public Long employeeId;
  public Long role;
  
  
  public Long getEmployeeId() {
    return employeeId;
  }
  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Long getRole() {
    return role;
  }
  public void setRole(Long role) {
    this.role = role;
  }
  
  

}
