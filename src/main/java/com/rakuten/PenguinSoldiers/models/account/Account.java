package com.rakuten.PenguinSoldiers.models.account;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.rakuten.PenguinSoldiers.models.training.Training;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@NamedQueries({
@NamedQuery(name = Account.FIND_BY_EMAIL, query = "select a from Account a where a.email = :email"),
@NamedQuery(name = Account.FIND_BY_USERNAME, query = "select a from Account a where a.username = :username"),
@NamedQuery(name = Account.FIND_EMPLOYEE, query = "select a from Account a, Hierarchy h where a.username = :username and h.managerId=a.id"),
@NamedQuery(name = Account.FIND_MANAGER, query = "select a from Account a, Hierarchy h where a.username = :username and h.employeeId=a.id")
})
public class Account implements java.io.Serializable {

	public static final String FIND_BY_EMAIL = "Account.findByEmail";
	public static final String FIND_BY_USERNAME= "Account.findByUsername";
	public static final String FIND_EMPLOYEE= "Account.findEmployee";
	public static final String FIND_MANAGER= "Account.findManager";

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
	public List<Training> trainings;

	private String role = "ROLE_USER";

	private String name;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String employeeNo;

	public Account() {
	  this.password="";
	}

	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	
	public boolean isSame(Account a){
	  if(a.getId()==null||this.getId()==null)return false;
	  return a.getId().equals(this.getId());
	}

}
