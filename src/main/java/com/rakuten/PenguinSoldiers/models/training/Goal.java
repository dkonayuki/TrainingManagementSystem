package com.rakuten.PenguinSoldiers.models.training;


import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "goal")

public class Goal implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
	
	@Lob
	private String content;
	
    protected Goal() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


}



