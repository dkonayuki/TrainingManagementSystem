package com.rakuten.PenguinSoldiers.models.goal;


import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "goal")
@NamedQuery(name = Goal.FIND_BY_ID, query = "select a from Goal a where a.training_id = :id")
public class Goal implements java.io.Serializable {

	
	public static final String FIND_BY_ID = "Goal.findById";
	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
	
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