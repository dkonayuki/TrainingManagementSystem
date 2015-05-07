package com.rakuten.PenguinSoldiers.entity;
import java.sql.Timestamp;


public class Training {
  
  private Long id;
  private String name;
  private String overview;
  private Long maxParticipants;
  private Timestamp openDate;
  private Timestamp closeDate;
  private String status;
  private String otherInfo;
  private String content;
  
  private Timestamp createdBy;
  
  
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
  public String getOverview() {
    return overview;
  }
  public void setOverview(String overview) {
    this.overview = overview;
  }
  public Long getMaxParticipants() {
    return maxParticipants;
  }
  public void setMaxParticipants(Long maxParticipants) {
    this.maxParticipants = maxParticipants;
  }
  public Timestamp getOpenDate() {
    return openDate;
  }
  public void setOpenDate(Timestamp openDate) {
    this.openDate = openDate;
  }
  public Timestamp getCloseDate() {
    return closeDate;
  }
  public void setCloseDate(Timestamp closeDate) {
    this.closeDate = closeDate;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getOtherInfo() {
    return otherInfo;
  }
  public void setOtherInfo(String otherInfo) {
    this.otherInfo = otherInfo;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Timestamp getCreatedBy() {
    return createdBy;
  }
  public void setCreatedBy(Timestamp createdBy) {
    this.createdBy = createdBy;
  }
  
  
  
  
  
}
