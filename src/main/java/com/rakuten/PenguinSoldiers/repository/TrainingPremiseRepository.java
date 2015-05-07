package com.rakuten.PenguinSoldiers.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.TrainingPremise;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class TrainingPremiseRepository {

  
  @PersistenceContext
  private EntityManager entityManager;
  
  
  public TrainingPremise save(TrainingPremise trainingCondition){
    Session session = entityManager.unwrap(Session.class);
    try {
//      if(trainingCondition.getId()==null)trainingCondition.setCreatedBy(Util.getNow());
      session.saveOrUpdate(trainingCondition);
      session.flush();
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    finally {
      
    }
    return trainingCondition;
  }
  
  public TrainingPremise getTrainingPremiseById(Long id){
    try {
      return entityManager.createQuery("select tc from TrainingCondition tc where tc.id = :id", TrainingPremise.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }
}
