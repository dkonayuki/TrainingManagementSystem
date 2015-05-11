package com.rakuten.PenguinSoldiers.models.training;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TargetService {

	@Autowired
	private TargetRepository targetRepository;
	
	@PostConstruct	
	protected void initialize() {
	}
	
	public Target create(Target target) {
		return targetRepository.save(target);
	}
	
  public Target findById(int id) {
    return targetRepository.findById(id);
  }

  public void delete(int id) throws DataAccessException {
    Target deletedtarget = targetRepository.findById(id);
    targetRepository.delete(deletedtarget);
  }

  public List<Target> findAll() {
    return targetRepository.findAll();
  }

  public void update(Target target) {
  	targetRepository.update(target);
  }

	public void save(Target target) {
		targetRepository.save(target);
	}
	
}
