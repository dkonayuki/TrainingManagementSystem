package com.rakuten.PenguinSoldiers.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.PenguinSoldiers.entity.TrainingVenue;
import com.rakuten.PenguinSoldiers.util.Util;


@Repository
@Transactional(readOnly = false)
public class TrainingVenueRepository {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  
  public TrainingVenue save(TrainingVenue trainingVenue){
    Session session = entityManager.unwrap(Session.class);
    try {
//      if(trainingVenue.getId()==null)trainingVenue.setCreatedBy(Util.getNow());
      session.saveOrUpdate(trainingVenue);
      session.flush();
    }
    catch (Exception e) {
      throw e;
    }
    finally {
      
    }
    return trainingVenue;
  }

  
  public TrainingVenue getTrainingVenueById(Long id){
    try {
      return entityManager.createQuery("select tv from TrainingVenue tv where tv.id = :id", TrainingVenue.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      System.out.println("id not found: "+ id);
      e.printStackTrace();
      return null;
    }
  }


}
