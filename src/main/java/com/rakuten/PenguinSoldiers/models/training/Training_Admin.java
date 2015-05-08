package com.rakuten.PenguinSoldiers.models.training;


import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "training_admin")

public class Training_Admin implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private Long user_id;
	private Long training_id;
	
    protected Training_Admin() {

	}
	
	public Training_Admin(Long user_id, Long training_id) {
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


