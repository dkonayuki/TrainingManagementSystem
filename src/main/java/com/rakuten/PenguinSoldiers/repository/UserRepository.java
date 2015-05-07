package com.rakuten.PenguinSoldiers.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.User;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class UserRepository {

  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Inject
  private PasswordEncoder passwordEncoder;
  
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
  
  public User getUser(Long employeeId){
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
  
  public Collection<User> getMembers(User u){
    Session session = entityManager.unwrap(Session.class);
    try {
//      session.createCriteria(User.class).add
      List<User> members=entityManager.createQuery("select u from User u where u.manager = :manager", User.class)
      .setParameter("manager", u).getResultList();
      Set<User> ret = new HashSet<User>(members);
      return ret;
//          .getSingleResult();
    } catch (PersistenceException e) {
      e.printStackTrace();
      return null;
    }
  }
  
  

  @Transactional
  public void testHier(){
    Session session = entityManager.unwrap(Session.class);
    Transaction transaction = null;
    try {
         
//        transaction = session.beginTransaction();
        
      User parent=new User();
      parent.setName("parent");
      parent.setEmployeeId(new Long(20));
      
        User parent2=new User();
        parent.setName("parent2");
        parent.setEmployeeId(new Long(23));
        
        User parent3=new User();
        parent.setName("parent3");
        parent.setEmployeeId(new Long(24));
        
        User child=new User();
        child.setName("child");
        child.setEmployeeId(new Long(21));
        
        User child2=new User();
        child2.setName("child2");
        child2.setEmployeeId(new Long(22));
        
        User child3=new User();
        child2.setName("child3");
        child2.setEmployeeId(new Long(25));
//        parent.addMember(child);
        
        parent.addMember(child);
        parent.addMember(child2);
        
//        Set<User> children=new HashSet<User>();
//        children.add(child);
//        children.add(child2);
//        parent.setMembers(children);
//        
        session.saveOrUpdate(child);
        session.saveOrUpdate(child2);
        session.saveOrUpdate(child3);
        session.saveOrUpdate(parent);
        session.saveOrUpdate(parent2);
        session.saveOrUpdate(parent3);
         session.flush();
//        transaction.commit();
    }catch (HibernateException e) {
        transaction.rollback();
        e.printStackTrace();
    } finally {
//        session.close();
    }
  }
  
  public void testHier2(){
    try{

      User child=this.getUserById(new Long(1));
      
      User parent=this.getUserById(new Long(4));
      User parent2=this.getUserById(new Long(5));
      User parent3=this.getUserById(new Long(6));
      
      
      User child2=this.getUserById(new Long(2));
      User child3=this.getUserById(new Long(3));
      
      parent3.addMember(child);
      this.save(child);
      this.save(parent3); 
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}

