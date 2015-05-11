package com.rakuten.PenguinSoldiers.models.training;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

	@Autowired
	private VenueRepository venueRepository;
	
	@PostConstruct	
	protected void initialize() {
	}
	
	public Venue create(Venue venue) {
		return venueRepository.save(venue);
	}
	
  public Venue findById(int id) {
    return venueRepository.findById(id);
  }

  public void delete(int id) throws DataAccessException {
    Venue deletedvenue = venueRepository.findById(id);
    venueRepository.delete(deletedvenue);
  }

  public List<Venue> findAll() {
    return venueRepository.findAll();
  }

  public void update(Venue venue) {
  	venueRepository.update(venue);
  }

	public void save(Venue venue) {
		venueRepository.save(venue);
	}
	
}
