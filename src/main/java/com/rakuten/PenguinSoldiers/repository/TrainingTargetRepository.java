package com.rakuten.PenguinSoldiers.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.TrainingTarget;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class TrainingTargetRepository {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  
  public TrainingTarget save(TrainingTarget trainingTarget){
    Session session = entityManager.unwrap(Session.class);
    try {
//      if(trainingTarget.getId()==null)trainingTarget.setCreatedBy(Util.getNow());
      session.saveOrUpdate(trainingTarget);
      session.flush();
    }
    catch (Exception e) {
      throw e;
    }
    finally {
      
    }
    return trainingTarget;
  }

  
  public TrainingTarget getTrainingTargetById(Long id){
    try {
      return entityManager.createQuery("select tt from TrainingTarget tt where tt.id = :id", TrainingTarget.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }


}
