package com.rakuten.PenguinSoldiers.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.Training;
import com.rakuten.PenguinSoldiers.entity.TrainingPremise;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class TrainingRepository {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  
  public Training save(Training training){
    Session session = entityManager.unwrap(Session.class);
    try {
      if(training.getId()==null)training.setCreatedBy(Util.getNow());
      session.saveOrUpdate(training);
      session.flush();
    }
    catch (Exception e) {
      throw e;
    }
    finally {
      
    }
    return training;
  }

  
  public Training getTrainingById(Long id){
    try {
      return entityManager.createQuery("select t from Training t where t.id = :id", Training.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }

}
