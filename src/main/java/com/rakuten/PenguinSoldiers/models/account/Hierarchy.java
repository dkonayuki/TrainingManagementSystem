package com.rakuten.PenguinSoldiers.models.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@SuppressWarnings("serial")
@Entity
@Table(name = "hierarchy", uniqueConstraints=
@UniqueConstraint(columnNames = {"managerId", "employeeId"}))
@NamedQueries({
@NamedQuery(name = Hierarchy.FIND_BY_MANAGER_ID_EMPLOYEE_ID, query = "select h from Hierarchy h where h.employeeId= :employeeId and h.managerId= :managerId")
})
public class Hierarchy implements java.io.Serializable {
  
  public static final String FIND_BY_MANAGER_ID_EMPLOYEE_ID="Hierarchy.findByManagerIdEmployeId";
  
  @Id
  @GeneratedValue
  private Long id;
  
  private Long managerId;
  private Long employeeId;
  
  public Long getManagerId() {
    return managerId;
  }
  public void setManagerId(Long managerId) {
    this.managerId = managerId;
  }
  public Long getEmployeeId() {
    return employeeId;
  }
  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }
  

}
