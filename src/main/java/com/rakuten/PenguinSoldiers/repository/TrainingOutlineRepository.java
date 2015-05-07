package com.rakuten.PenguinSoldiers.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.TrainingOutline;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class TrainingOutlineRepository {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  
  public TrainingOutline save(TrainingOutline trainingOutline){
    Session session = entityManager.unwrap(Session.class);
    try {
//      if(trainingOutline.getId()==null)trainingOutline.setCreatedBy(Util.getNow());
      session.saveOrUpdate(trainingOutline);
      session.flush();
    }
    catch (Exception e) {
      throw e;
    }
    finally {
      
    }
    return trainingOutline;
  }

  
  public TrainingOutline getTrainingOutlineById(Long id){
    try {
      return entityManager.createQuery("select to from TrainingOutline to where to.id = :id", TrainingOutline.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }


}
