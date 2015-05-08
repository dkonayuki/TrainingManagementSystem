package com.rakuten.PenguinSoldiers.models.account;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "role_user")

public class Role_User implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private Long user_id;
	private Long role_id;
	
    protected Role_User() {

	}
	
	public Role_User(Long user_id, Long role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public Long getId() {
		return id;
	}

	public Long getRoleID()
	{
		return role_id;
	}
	
	public void setRoleID(Long role_id)
	{
		this.role_id = role_id;
	}
	
	public Long getUserID() {
		return user_id;
	}

	public void setUserID(Long user_id) {
		this.user_id = user_id;
	}



}

