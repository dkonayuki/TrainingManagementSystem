package com.rakuten.PenguinSoldiers.models.training;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TrainingRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Training save(Training training) {
		entityManager.persist(training);
		return training;
	}

	public Training findById(int id) {
		try {
			return entityManager.createNamedQuery(Training.FIND_BY_ID, Training.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	public List<Training> findActiveTraining() {
    try {
      return entityManager.createNamedQuery(Training.FIND_ACTIVE_TRAINING, Training.class)
          .getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public void update(Training training) {
		entityManager.merge(training);
	}

	public void delete(Training training) {
    entityManager.remove(entityManager.contains(training) ? training : entityManager.merge(training));
	}

	public List<Training> findAll() {
		return entityManager.createQuery("from Training", Training.class).getResultList();
	}

}
