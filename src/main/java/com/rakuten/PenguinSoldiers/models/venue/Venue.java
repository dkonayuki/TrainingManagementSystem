package com.rakuten.PenguinSoldiers.models.venue;


import javax.persistence.*;

import com.rakuten.PenguinSoldiers.models.training.Training;


@SuppressWarnings("serial")
@Entity
@Table(name = "venue")
@NamedQuery(name = Venue.FIND_BY_ID, query = "select a from Venue a where a.id = :id")

public class Venue implements java.io.Serializable {

	public static final String FIND_BY_ID = "Venue.findById";

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;

	private String city;
	private String name;
	private String address;


	protected Venue() {

	}
	public Venue(String name)
	{
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}

}


