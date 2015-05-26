package com.rakuten.PenguinSoldiers.models.training;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StandardQuestionnaireRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public StandardQuestionnaire save(StandardQuestionnaire StandardQuestionaire) {
    entityManager.persist(StandardQuestionaire);
    return StandardQuestionaire;
  }
  
  public StandardQuestionnaire findById(Long id) {
    try {
      return entityManager.createNamedQuery(StandardQuestionnaire.FIND_BY_ID, StandardQuestionnaire.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }

  public StandardQuestionnaire completed(Long trainingId, Long userId) {
    try {
      return entityManager.createNamedQuery(StandardQuestionnaire.IS_COMPLETED, StandardQuestionnaire.class)
          .setParameter("trainingId", trainingId).setParameter("userId", userId)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
  public List<Object[]> employeeCompleted(Long trainingId, Long userId) {
    try {
      return entityManager.createNativeQuery("select a.name, sq.id from training_user tu, account a, standardQuestionnaire sq where sq.trainingId=tu.trainingId and sq.userId=a.id and tu.trainingId=:trainingId and  a.id=tu.userId and a.id in (select acc.id from Account acc, Hierarchy h where h.managerId=:managerId and acc.id=h.employeeId)")
          .setParameter("trainingId", trainingId).setParameter("managerId", userId).getResultList();
    } catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  
    
  public void update(StandardQuestionnaire StandardQuestionaire) {
    entityManager.merge(StandardQuestionaire);
  }

  public void delete(StandardQuestionnaire StandardQuestionaire) {
    entityManager.remove(entityManager.contains(StandardQuestionaire) ? StandardQuestionaire : entityManager.merge(StandardQuestionaire));
  }

  public List<StandardQuestionnaire> findAll() {
    return entityManager.createQuery("from StandardQuestionaire", StandardQuestionnaire.class).getResultList();
  }
  
  

}
