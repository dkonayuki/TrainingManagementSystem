package com.rakuten.PenguinSoldiers.models.account;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HierarchyRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public Hierarchy save(Hierarchy hierarchy) {
    entityManager.persist(hierarchy);
    return hierarchy;
  }
  
  
  @Transactional
  public void save(List<Hierarchy> list) {
    for(Hierarchy h : list){
      entityManager.persist(h);
    }
  }
  
  public boolean isExist(Hierarchy h) {
    try {
      return this.findByManagerIdAndEmployeeId(h.getManagerId(), h.getEmployeeId())!=null;
    } catch (PersistenceException e) {
      return false;
    }
  }
  
  public Hierarchy findByManagerIdAndEmployeeId(Long managerId,Long employeeId){
    try {
      return entityManager.createNamedQuery(Hierarchy.FIND_BY_MANAGER_ID_EMPLOYEE_ID, Hierarchy.class)
          .setParameter("managerId", managerId)
          .setParameter("employeeId", employeeId)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
}
