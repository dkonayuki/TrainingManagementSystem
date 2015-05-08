package com.rakuten.PenguinSoldiers.models.training;


import javax.persistence.*;

import org.hibernate.type.TextType;


@SuppressWarnings("serial")
@Entity
@Table(name = "premise")

public class Premise implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
	
	@Lob
	private String content;
	
    protected Premise() {

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

}
