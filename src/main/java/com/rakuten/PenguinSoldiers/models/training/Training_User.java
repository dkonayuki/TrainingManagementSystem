package com.rakuten.PenguinSoldiers.models.training;


import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "training_user")

public class Training_User implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Long user_id;
	private Long training_id;
	
    protected Training_User() {

	}
	
	public Training_User(Long user_id, Long training_id) {
		this.user_id = user_id;
		this.training_id = training_id;
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
	
	public Long getUserID() {
		return user_id;
	}

	public void setUserID(Long user_id) {
		this.user_id = user_id;
	}



}


