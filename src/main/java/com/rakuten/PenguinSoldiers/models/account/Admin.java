package com.rakuten.PenguinSoldiers.models.account;

import java.sql.Timestamp;


import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "admin")
@NamedQueries({
@NamedQuery(name = Admin.FIND_BY_ID, query = "select ad from Admin ad where ad.userId=:id")
})
public class Admin implements java.io.Serializable {
  
  
  public static final String FIND_BY_ID = "Admin.findAdminById";
  
  @Id
  @GeneratedValue
  private Long id;
  
  @Column(unique = true)
  private Long userId;
  
  private Long addedBy;
  
  private Timestamp addedOn;
  
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

  public Long getAddedBy() {
    return addedBy;
  }

  public void setAddedBy(Long addedBy) {
    this.addedBy = addedBy;
  }

  public Timestamp getAddedOn() {
    return addedOn;
  }

  public void setAddedOn(Timestamp addedOn) {
    this.addedOn = addedOn;
  }
  
  
}
