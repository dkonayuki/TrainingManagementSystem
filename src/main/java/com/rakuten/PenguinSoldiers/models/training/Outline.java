package com.rakuten.PenguinSoldiers.models.training;

import javax.persistence.*;

import java.sql.Timestamp;


@SuppressWarnings("serial")
@Entity
@Table(name = "outline")
@NamedQuery(name = Outline.FIND_BY_ID, query = "select a from Outline a where a.training_id = :id")

public class Outline implements java.io.Serializable {

	public static final String FIND_BY_ID = "Outline.findById";
	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
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
	
	public Long getTraining_id() {
		return training_id;
	}

	public void setTraining_id(Long training_id) {
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


