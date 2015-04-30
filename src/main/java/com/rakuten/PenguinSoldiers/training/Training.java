package com.rakuten.PenguinSoldiers.training;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "training")
public class Training implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	protected Training() {

	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
