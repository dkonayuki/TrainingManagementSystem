package com.rakuten.PenguinSoldiers.models.target;


import javax.persistence.*;

import org.hibernate.type.TextType;


@SuppressWarnings("serial")
@Entity
@Table(name = "target")
@NamedQuery(name = Target.FIND_BY_ID, query = "select a from Target a where a.training_id = :id")

public class Target implements java.io.Serializable {

	public static final String FIND_BY_ID = "Target.findById";
	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
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


