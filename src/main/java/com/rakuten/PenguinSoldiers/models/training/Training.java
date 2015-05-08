package com.rakuten.PenguinSoldiers.models.training;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "training")
@NamedQuery(name = Training.FIND_BY_ID, query = "select a from Training a where a.id = :id")
public class Training implements java.io.Serializable {

	public static final String FIND_BY_ID = "Training.findById";

	@Id
	@GeneratedValue
	private int id;
	
	private String name;

	protected Training() {
	}
	
	public Training(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
