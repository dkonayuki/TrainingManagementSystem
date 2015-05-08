package com.rakuten.PenguinSoldiers.models.training;

import javax.persistence.*;
import java.sql.Timestamp;


@SuppressWarnings("serial")
@Entity
@Table(name = "outline")

public class Outline implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
	@Lob
	private String content;
	private Timestamp date;
	
    protected Outline() {

	}

	public Long getId() {
		return id;
	}

	public Long getTrainingID()
	{
		return training_id;
	}
	
	public void setTrainingID(Long training_id)
	{
		this.training_id = training_id;
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



}


