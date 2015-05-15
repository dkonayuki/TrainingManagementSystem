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
@Table(name = "training_user")
@NamedQueries({
@NamedQuery(name = TrainingUser.FIND_BY_ID, query = "select a from TrainingUser a where a.id = :id"),
@NamedQuery(name = TrainingUser.FIND_REGISTERED_EMPLOYEE, query = "select a from TrainingUser tu, Account a where tu.trainingId = :trainingId and a.id=tu.userId and a.id in (select acc.id from Account acc, Hierarchy h where h.managerId=:managerId and acc.id=h.employeeId)"),
@NamedQuery(name = TrainingUser.FIND_NOT_REGISTERED_EMPLOYEE, query = "select a FROM Hierarchy h, Account a WHERE h.managerId=:managerId and a.id=h.employeeId and a.id not in ( select tu.userId from TrainingUser tu where tu.trainingId=:trainingId )"),
@NamedQuery(name = TrainingUser.FIND_BY_TRAININIG_ID_ACCOUNT_ID, query = "select tu from TrainingUser tu where tu.trainingId=:trainingId and tu.userId=:accountId")
})
public class TrainingUser {
  
  public static final String FIND_BY_ID="TrainingUser.findById";
  public static final String FIND_REGISTERED_EMPLOYEE="TrainingUser.findRegisteredUser";
  public static final String FIND_NOT_REGISTERED_EMPLOYEE="TrainingUser.findNotRegisteredEmployee";
  public static final String FIND_BY_TRAININIG_ID_ACCOUNT_ID="TrainingUser.findByTrainingIdAccountId";
  
  
  @Id
  @GeneratedValue
  private Long id;
  
  private Long userId;
  private Long trainingId;
  
  
  @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private Timestamp addedOn;
  private Long addedBy;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  public Long getTrainingId() {
    return trainingId;
  }
  public void setTrainingId(Long trainingId) {
    this.trainingId = trainingId;
  }
  public Timestamp getAddedOn() {
    return addedOn;
  }
  public void setAddedOn(Timestamp addedOn) {
    this.addedOn = addedOn;
  }
  public Long getAddedBy() {
    return addedBy;
  }
  public void setAddedBy(Long addedBy) {
    this.addedBy = addedBy;
  }
  
  
  
}
