package com.rakuten.PenguinSoldiers.models.training;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StandardQuestionaireRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public StandardQuestionaire save(StandardQuestionaire StandardQuestionaire) {
    entityManager.persist(StandardQuestionaire);
    return StandardQuestionaire;
  }

  public StandardQuestionaire completed(Long trainingId, Long userId) {
    try {
      return entityManager.createNamedQuery(StandardQuestionaire.IS_COMPLETED, StandardQuestionaire.class)
          .setParameter("trainingId", trainingId).setParameter("userId", userId)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
  
    
  public void update(StandardQuestionaire StandardQuestionaire) {
    entityManager.merge(StandardQuestionaire);
  }

  public void delete(StandardQuestionaire StandardQuestionaire) {
    entityManager.remove(entityManager.contains(StandardQuestionaire) ? StandardQuestionaire : entityManager.merge(StandardQuestionaire));
  }

  public List<StandardQuestionaire> findAll() {
    return entityManager.createQuery("from StandardQuestionaire", StandardQuestionaire.class).getResultList();
  }

}
