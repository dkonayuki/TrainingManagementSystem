package com.rakuten.PenguinSoldiers.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import com.rakuten.PenguinSoldiers.entity.Training;
import com.rakuten.PenguinSoldiers.util.Util;

public class TrainingRespository {
  
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

}
