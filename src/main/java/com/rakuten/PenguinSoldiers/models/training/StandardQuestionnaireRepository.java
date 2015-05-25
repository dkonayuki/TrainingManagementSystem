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

  public StandardQuestionnaire completed(Long trainingId, Long userId) {
    try {
      return entityManager.createNamedQuery(StandardQuestionnaire.IS_COMPLETED, StandardQuestionnaire.class)
          .setParameter("trainingId", trainingId).setParameter("userId", userId)
          .getSingleResult();
    } catch (PersistenceException e) {
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
