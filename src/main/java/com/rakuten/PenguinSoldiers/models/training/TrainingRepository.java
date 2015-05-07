package com.rakuten.PenguinSoldiers.models.training;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
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


}
