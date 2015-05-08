package com.rakuten.PenguinSoldiers.models.account;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "role")

public class Role implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

    protected Role() {

	}
	
	public Role(String name) {
		this.name = name;
	}


	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

}

