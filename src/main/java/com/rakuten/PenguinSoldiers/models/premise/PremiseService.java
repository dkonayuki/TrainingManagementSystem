package com.rakuten.PenguinSoldiers.models.premise;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PremiseService {

	@Autowired
	private PremiseRepository premiseRepository;
	
	@PostConstruct	
	protected void initialize() {
	}
	
	public Premise create(Premise premise) {
		return premiseRepository.save(premise);
	}
	
  public Premise findById(int id) {
    return premiseRepository.findById(id);
  }

  public void delete(int id) throws DataAccessException {
    Premise deletedpremise = premiseRepository.findById(id);
    premiseRepository.delete(deletedpremise);
  }

  public List<Premise> findAll() {
    return premiseRepository.findAll();
  }

  public void update(Premise premise) {
  	premiseRepository.update(premise);
  }

	public void save(Premise premise) {
		premiseRepository.save(premise);
	}
	
}
