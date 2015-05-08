package com.rakuten.PenguinSoldiers.models.training;


import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "venue")
public class Venue implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Long training_id;
	private String city;
	private String name;
	private String address;
	
	
	protected Venue() {

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
	public Long getTrainingID()
	{
		return training_id;
	}
	public void setTrainingID(Long training_id)
	{
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


