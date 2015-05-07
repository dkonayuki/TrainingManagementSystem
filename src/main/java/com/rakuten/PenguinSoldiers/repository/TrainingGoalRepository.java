package com.rakuten.PenguinSoldiers.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.TrainingGoal;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class TrainingGoalRepository {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  
  public TrainingGoal save(TrainingGoal trainingGoal){
    Session session = entityManager.unwrap(Session.class);
    try {
//      if(trainingGoal.getId()==null)trainingGoal.setCreatedBy(Util.getNow());
      session.saveOrUpdate(trainingGoal);
      session.flush();
    }
    catch (Exception e) {
      throw e;
    }
    finally {
      
    }
    return trainingGoal;
  }

  
  public TrainingGoal getTrainingGoalById(Long id){
    try {
      return entityManager.createQuery("select tg from TrainingGoal tg where tg.id = :id", TrainingGoal.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }


}
