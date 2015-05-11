package com.rakuten.PenguinSoldiers.models.training;


import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OutlineRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Outline save(Outline outline) {
		entityManager.persist(outline);
		return outline;
	}

	public Outline findById(int id) {
		try {
			return entityManager.createNamedQuery(Outline.FIND_BY_ID, Outline.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	public void update(Outline outline) {
		entityManager.merge(outline);
	}

	public void delete(Outline outline) {
    entityManager.remove(entityManager.contains(outline) ? outline : entityManager.merge(outline));
	}

	public List<Outline> findAll() {
		return entityManager.createQuery("from outline", Outline.class).getResultList();
	}

}
