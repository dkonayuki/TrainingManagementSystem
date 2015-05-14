package com.rakuten.PenguinSoldiers.models.target;


import javax.persistence.*;

import org.hibernate.type.TextType;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.training.Training;


@SuppressWarnings("serial")
@Entity
@Table(name = "target")
@NamedQuery(name = Target.FIND_BY_ID, query = "select a from Target a where a.id = :id")

public class Target implements java.io.Serializable {

	public static final String FIND_BY_ID = "Target.findById";
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;
	
	@Lob
	private String content;

	protected Target() {

	}
	public Target(String content)
	{
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


