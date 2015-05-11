package com.rakuten.PenguinSoldiers.models.training;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OutlineService {

	@Autowired
	private OutlineRepository outlineRepository;
	
	@PostConstruct	
	protected void initialize() {
	}
	
	public Outline create(Outline outline) {
		return outlineRepository.save(outline);
	}
	
  public Outline findById(int id) {
    return outlineRepository.findById(id);
  }

  public void delete(int id) throws DataAccessException {
    Outline deletedoutline = outlineRepository.findById(id);
    outlineRepository.delete(deletedoutline);
  }

  public List<Outline> findAll() {
    return outlineRepository.findAll();
  }

  public void update(Outline outline) {
  	outlineRepository.update(outline);
  }

	public void save(Outline outline) {
		outlineRepository.save(outline);
	}
	
}
