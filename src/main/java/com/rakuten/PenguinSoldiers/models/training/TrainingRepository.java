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
	
	public Training findById(Long id) {
    try {
      return entityManager.createNamedQuery(Training.FIND_BY_ID, Training.class)
          .setParameter("id", id)
          .getSingleResult();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public List<Training> findByName(String name) {
    try {
      return entityManager.createNamedQuery(Training.FIND_BY_NAME, Training.class)
          .setParameter("name", "%" + name + "%")
          .getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public List<Training> findRegisteredTraining(Long id, String name) {
    try {
      return entityManager.createNamedQuery(Training.FIND_REGISTERED_TRAINING, Training.class)
          .setParameter("id", id).setParameter("name", name)
          .getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public List<Training> findNotRegisteredTraining(Long id, String name) {
    try {
      return entityManager.createNamedQuery(Training.FIND_NOT_REGISTERED_TRAINING, Training.class)
          .setParameter("id", id).setParameter("name", name)
          .getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public List<Training> findPastRegisteredTraining(Long id, String name) {
    try {
      return entityManager.createNamedQuery(Training.FIND_PAST_REGISTERED_TRAINING, Training.class)
          .setParameter("id", id).setParameter("name", name)
          .getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public List<Training> findActiveTraining(String name) {
    try {
      return entityManager.createNamedQuery(Training.FIND_ACTIVE_TRAINING, Training.class)
          .setParameter("name", name)
          .getResultList();
    } catch (PersistenceException e) {
      return null;
    }
  }
	
	public List<Training> findActiveTraining() {
    return findActiveTraining("%");
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
