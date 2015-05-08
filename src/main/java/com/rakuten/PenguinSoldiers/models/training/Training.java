package com.rakuten.PenguinSoldiers.models.training;

//import java.security.Timestamp;

import javax.persistence.*;


import org.hibernate.type.TextType;
import java.sql.Timestamp;



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
    private TextType overview;
	private int max_participants;
    private Timestamp due_date;
    private Timestamp start_date;
    private String status;
	
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
	
	public TextType getOverview()
	{
		return overview;
	}
	public void setOverview(TextType overview)
	{
		this.overview = overview;
	}
	public int getParticipantsNum()
	{
		return max_participants;
	}
	public void setParticipantsNum(int max_participants)
	{
		this.max_participants = max_participants;
	}
	public Timestamp getDuedate()
	{
		return due_date;
	}
	public void setDuedate(Timestamp due_date)
	{
		this.due_date = due_date;
	}
	public Timestamp getStartdate()
	{
		return start_date;
	}
	public void setStartdate(Timestamp start_date)
	{
		this.start_date = start_date;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}


