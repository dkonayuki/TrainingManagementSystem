package com.rakuten.PenguinSoldiers.models.premise;


import javax.persistence.*;

import org.hibernate.type.TextType;

import com.rakuten.PenguinSoldiers.models.training.Training;


@SuppressWarnings("serial")
@Entity
@Table(name = "premise")
@NamedQuery(name = Premise.FIND_BY_ID, query = "select a from Premise a where a.id = :id")

public class Premise implements java.io.Serializable {

	public static final String FIND_BY_ID = "Premise.findById";
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;


	@Lob
	private String content;

	protected Premise() {

	}

	public Premise(String content)
	{
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

}
