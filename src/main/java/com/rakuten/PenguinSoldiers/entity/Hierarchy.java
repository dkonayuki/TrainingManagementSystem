package com.rakuten.PenguinSoldiers.entity;

import java.io.Serializable;

public class Hierarchy implements Serializable{
  
  private Long id;
  private User high;
  private User low;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public User getHigh() {
    return high;
  }
  public void setHigh(User high) {
    this.high = high;
  }
  public User getLow() {
    return low;
  }
  public void setLow(User low) {
    this.low = low;
  }
  
  
}