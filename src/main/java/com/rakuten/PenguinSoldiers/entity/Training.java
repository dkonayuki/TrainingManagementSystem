package com.rakuten.PenguinSoldiers.entity;
import java.sql.Timestamp;
import java.util.Collection;


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
  
  private Collection<TrainingPremise> premises;
  private Collection<TrainingOutline> outlines;
  private Collection<TrainingGoal> goals;
  private Collection<TrainingTarget> targets;
  private Collection<TrainingVenue> venues;
  
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
  
  public Collection<TrainingPremise> getPremises() {
    return premises;
  }
  public void setPremises(Collection<TrainingPremise> premises) {
    this.premises = premises;
  }
  public Collection<TrainingOutline> getOutlines() {
    return outlines;
  }
  public void setOutlines(Collection<TrainingOutline> outlines) {
    this.outlines = outlines;
  }
  public Collection<TrainingGoal> getGoals() {
    return goals;
  }
  public void setGoals(Collection<TrainingGoal> goals) {
    this.goals = goals;
  }
  public Collection<TrainingTarget> getTargets() {
    return targets;
  }
  public void setTargets(Collection<TrainingTarget> targets) {
    this.targets = targets;
  }
  public Collection<TrainingVenue> getVenues() {
    return venues;
  }
  public void setVenues(Collection<TrainingVenue> venues) {
    this.venues = venues;
  }
  
  
  
  
  
}
