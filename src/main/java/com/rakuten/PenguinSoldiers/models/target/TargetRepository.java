package com.rakuten.PenguinSoldiers.models.target;


import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TargetRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Target save(Target target) {
		entityManager.persist(target);
		return target;
	}

	public Target findById(int id) {
		try {
			return entityManager.createNamedQuery(Target.FIND_BY_ID, Target.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	public void update(Target target) {
		entityManager.merge(target);
	}

	public void delete(Target target) {
    entityManager.remove(entityManager.contains(target) ? target : entityManager.merge(target));
	}

	public List<Target> findAll() {
		return entityManager.createQuery("from target", Target.class).getResultList();
	}

}