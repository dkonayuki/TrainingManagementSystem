package com.rakuten.PenguinSoldiers.models.outline;

import javax.persistence.*;

import com.rakuten.PenguinSoldiers.models.training.Training;

import java.sql.Timestamp;


@SuppressWarnings("serial")
@Entity
@Table(name = "outline")
@NamedQuery(name = Outline.FIND_BY_ID, query = "select a from Outline a where a.id = :id")

public class Outline implements java.io.Serializable {

	public static final String FIND_BY_ID = "Outline.findById";
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;

	@Lob
	private String content;
	private Timestamp date;

	protected Outline() {

	}

	public Outline(String content)
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
	public Timestamp getDate()
	{
		return date;
	}
	public void setDate(Timestamp date)
	{
		this.date = date;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}



}


