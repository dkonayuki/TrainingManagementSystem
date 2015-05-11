package com.rakuten.PenguinSoldiers.models.training;


import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VenueRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Venue save(Venue venue) {
		entityManager.persist(venue);
		return venue;
	}

	public Venue findById(int id) {
		try {
			return entityManager.createNamedQuery(Venue.FIND_BY_ID, Venue.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}
	
	public void update(Venue venue) {
		entityManager.merge(venue);
	}

	public void delete(Venue venue) {
    entityManager.remove(entityManager.contains(venue) ? venue : entityManager.merge(venue));
	}

	public List<Venue> findAll() {
		return entityManager.createQuery("from venue", Venue.class).getResultList();
	}

}