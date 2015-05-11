package com.rakuten.PenguinSoldiers.models.training;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	@PostConstruct	
	protected void initialize() {
	}
	
	public Goal create(Goal goal) {
		return goalRepository.save(goal);
	}
	
  public Goal findById(int id) {
    return goalRepository.findById(id);
  }

  public void delete(int id) throws DataAccessException {
    Goal deletedgoal = goalRepository.findById(id);
    goalRepository.delete(deletedgoal);
  }

  public List<Goal> findAll() {
    return goalRepository.findAll();
  }

  public void update(Goal goal) {
  	goalRepository.update(goal);
  }

	public void save(Goal goal) {
		goalRepository.save(goal);
	}
	
}
