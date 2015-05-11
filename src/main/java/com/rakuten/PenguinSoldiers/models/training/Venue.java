package com.rakuten.PenguinSoldiers.models.training;


import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "venue")
@NamedQuery(name = Venue.FIND_BY_ID, query = "select a from Venue a where a.training_id = :id")

public class Venue implements java.io.Serializable {

	public static final String FIND_BY_ID = "Venue.findById";
	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTraining_id() {
		return training_id;
	}

	public void setTraining_id(Long training_id) {
		this.training_id = training_id;
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


