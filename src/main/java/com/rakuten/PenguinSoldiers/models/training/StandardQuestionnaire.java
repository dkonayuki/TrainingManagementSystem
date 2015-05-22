package com.rakuten.PenguinSoldiers.models.training;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "standardQuestionnaire")
@NamedQueries({
  @NamedQuery(name = StandardQuestionnaire.IS_COMPLETED, query = "select a from StandardQuestionnaire a where a.userId=:userId and a.trainingId=:trainingId")
})
public class StandardQuestionnaire implements java.io.Serializable {
  
  public static final String IS_COMPLETED = "StandardQuestionaire.isCompleted";
  
  @Id
  @GeneratedValue
  private Long id;
  
  private String helpful;
  private String understand;
  private String atmosphere;
  private String trainingCourse;
  private String curriculumPace;
  
  private String positive;
  private String improvement;
  
  private String followUp;
  
  private Long trainingId;
  private Long userId;
  
  @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp completedOn;
  
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getHelpful() {
    return helpful;
  }

  public void setHelpful(String helpful) {
    this.helpful = helpful;
  }

  public String getUnderstand() {
    return understand;
  }

  public void setUnderstand(String understand) {
    this.understand = understand;
  }

  public String getAtmosphere() {
    return atmosphere;
  }

  public void setAtmosphere(String atmosphere) {
    this.atmosphere = atmosphere;
  }

  public String getTrainingCourse() {
    return trainingCourse;
  }

  public void setTrainingCourse(String trainingCourse) {
    this.trainingCourse = trainingCourse;
  }

  public String getCurriculumPace() {
    return curriculumPace;
  }

  public void setCurriculumPace(String curriculumPace) {
    this.curriculumPace = curriculumPace;
  }

  public String getImprovement() {
    return improvement;
  }

  public void setImprovement(String improvement) {
    this.improvement = improvement;
  }

  public String getFollowUp() {
    return followUp;
  }

  public void setFollowUp(String followUp) {
    this.followUp = followUp;
  }

  public String getPositive() {
    return positive;
  }

  public void setPositive(String positive) {
    this.positive = positive;
  }
  
  public Long getTrainingId() {
    return trainingId;
  }

  public void setTrainingId(Long trainingId) {
    this.trainingId = trainingId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
  
  
  
  

}
