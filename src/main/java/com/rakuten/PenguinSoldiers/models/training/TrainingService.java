package com.rakuten.PenguinSoldiers.models.training;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@PostConstruct	
	protected void initialize() {
	}
	
	public Training create(Training training) {
		return trainingRepository.save(training);
	}
	
  public Training findById(int id) {
    return trainingRepository.findById(id);
  }

  public void delete(int id) throws DataAccessException {
    Training deletedTraining = trainingRepository.findById(id);
    trainingRepository.delete(deletedTraining);
  }

  public List<Training> findAll() {
    return trainingRepository.findAll();
  }

  /*
  public Training update(Training training) throws DataAccessException {
    Training updatedTraining = trainingRepository.findById(training.getId());

    updatedTraining.setName(training.getName());
    return updatedTraining;
  }*/
  public void update(Training training) {
  	trainingRepository.update(training);
  }

	public void save(Training training) {
		trainingRepository.save(training);
	}
	
	public List<Training> findActiveTraining(){
	  return trainingRepository.findActiveTraining();
	}

}
