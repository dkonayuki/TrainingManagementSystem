package com.rakuten.PenguinSoldiers.models.admin;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.models.account.Account;

@Repository
@Transactional
public class AdminRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  private Admin save(Admin admin) {
    entityManager.persist(admin);
    return admin;
  }
  
  public Admin addAdmin(Admin newAdmin){
    if(isAdmin(newAdmin.getAddedBy()))
      return save(newAdmin);
    return null;
  }
  
  public boolean isAdmin(Long id){
    return findAdmin(id)!=null;
  }
  
  public Admin findAdmin(Long id){
    try {
      return entityManager.createNamedQuery(Admin.FIND_BY_ID, Admin.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  
}
