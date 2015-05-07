package com.rakuten.PenguinSoldiers.repository;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.UserInfo;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class UserInfoRepository {
  
  
  @PersistenceContext
  private EntityManager entityManager;

  
  public UserInfo save(UserInfo userInfo) {
    Session session = entityManager.unwrap(Session.class);
    try {
      if(userInfo.getId()==null)userInfo.setCreatedTimestamp(Util.getNow());
      session.saveOrUpdate(userInfo);
      session.flush();
    }
    catch (Exception e) {
      throw e;
    }
    finally {
      
    }
    return userInfo;
  }
  
  public UserInfo getUserById(Long id){
    try {
      return entityManager.createQuery("select u from UserInfo u where u.id = :id", UserInfo.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }
  
  public UserInfo getUserByEmployeeId(Long employeeId){
    try {
      return entityManager.createQuery("select u from UserInfo u where u.employeeId = :employeeId", UserInfo.class)
          .setParameter("employeeId", employeeId)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  public UserInfo getUserByUsername(String username){
    try {
      return entityManager.createQuery("select u from UserInfo u where u.username = :username", UserInfo.class)
          .setParameter("username", username)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("username not found: "+ username);
      e.printStackTrace();
      return null;
    }
  }
  
  public Collection<UserInfo> getManagers(UserInfo u){
    Session session = entityManager.unwrap(Session.class);
    try {
      List<UserInfo> managers=entityManager.createQuery("select u from UserInfo u,  where u.manager = :manager", UserInfo.class)
      .setParameter("manager", u).getResultList();
      Set<UserInfo> ret = new HashSet<UserInfo>(managers);
      return ret;
    } catch (PersistenceException e) {
      e.printStackTrace();
      return null;
    }
  }

}
