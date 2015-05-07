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

import com.rakuten.PenguinSoldiers.entity.User;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class UserRepository {

  
  @PersistenceContext
  private EntityManager entityManager;
//  @Transactional
//  public User save(User user) {
//
//    Session session = entityManager.unwrap(Session.class);
//    try {
//      session.saveOrUpdate(user);
//    }
//    catch (Exception e) {
//
//      throw e;
//    }
//    finally {
//    }
//
//    return user;
//  }
//  
  public User save(User user) {
    Session session = entityManager.unwrap(Session.class);
    try {
      if(user.getId()==null)user.setCreatedTimestamp(Util.getNow());
      session.saveOrUpdate(user);
      session.flush();
    }
    catch (Exception e) {
      throw e;
    }
    finally {
      
    }
    return user;
  }
  
  public User getUserById(Long id){
    try {
      return entityManager.createQuery("select u from User u where u.id = :id", User.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }
  
  public User getUserByEmployeeId(Long employeeId){
    try {
      return entityManager.createQuery("select u from User u where u.employeeId = :employeeId", User.class)
          .setParameter("employeeId", employeeId)
          .getSingleResult();
    } catch (PersistenceException e) {
//      System.out.println("employeeId not found: "+ employeeId);
//      e.printStackTrace();
      return null;
    }
  }
  
  public User getUserByUsername(String username){
    try {
      return entityManager.createQuery("select u from User u where u.username = :username", User.class)
          .setParameter("username", username)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("username not found: "+ username);
      e.printStackTrace();
      return null;
    }
  }
  
  
}

