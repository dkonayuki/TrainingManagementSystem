package com.rakuten.PenguinSoldiers.models.training;


import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PremiseRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Premise save(Premise premise) {
		entityManager.persist(premise);
		return premise;
	}

	public Premise findById(int id) {
		try {
			return entityManager.createNamedQuery(Premise.FIND_BY_ID, Premise.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	public void update(Premise premise) {
		entityManager.merge(premise);
	}

	public void delete(Premise premise) {
    entityManager.remove(entityManager.contains(premise) ? premise : entityManager.merge(premise));
	}

	public List<Premise> findAll() {
		return entityManager.createQuery("from Premise", Premise.class).getResultList();
	}

}
