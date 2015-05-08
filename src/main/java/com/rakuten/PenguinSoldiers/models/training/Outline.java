package com.rakuten.PenguinSoldiers.models.training;

import javax.persistence.*;

import org.hibernate.type.TextType;
import java.sql.Timestamp;


@SuppressWarnings("serial")
@Entity
@Table(name = "outline")

public class Outline implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
	private TextType content;
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
	
	public TextType getContent() {
		return content;
	}

	public void setContent(TextType content) {
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


