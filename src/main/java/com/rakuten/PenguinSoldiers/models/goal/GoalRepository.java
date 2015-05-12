package com.rakuten.PenguinSoldiers.models.goal;


import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GoalRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Goal save(Goal goal) {
		entityManager.persist(goal);
		return goal;
	}

	public Goal findById(int id) {
		try {
			return entityManager.createNamedQuery(Goal.FIND_BY_ID, Goal.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	public void update(Goal goal) {
		entityManager.merge(goal);
	}

	public void delete(Goal goal) {
    entityManager.remove(entityManager.contains(goal) ? goal : entityManager.merge(goal));
	}

	public List<Goal> findAll() {
		return entityManager.createQuery("from Goal", Goal.class).getResultList();
	}

}
