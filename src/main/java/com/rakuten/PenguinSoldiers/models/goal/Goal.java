package com.rakuten.PenguinSoldiers.models.goal;


import javax.persistence.*;

import com.rakuten.PenguinSoldiers.models.training.Training;

@SuppressWarnings("serial")
@Entity
@Table(name = "goal")
@NamedQuery(name = Goal.FIND_BY_ID, query = "select a from Goal a where a.id = :id")
public class Goal implements java.io.Serializable {

	
	public static final String FIND_BY_ID = "Goal.findById";
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;
	
	@Lob
	private String content;
	
    protected Goal() {

	}
	public Goal(String content) {
		this.content = content;

	}

	public Long getId() {
		return id;
	}

	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}