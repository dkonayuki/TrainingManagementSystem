package com.rakuten.PenguinSoldiers.models.training;

//import java.security.Timestamp;

import javax.persistence.*;

import org.hibernate.type.TextType;
import java.sql.Timestamp;

@SuppressWarnings("serial")
@Entity
@Table(name = "training")
public class Training implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
    private TextType overview;
	private int max_participants;
    private Timestamp due_date;
    private Timestamp start_date;
    private String status;
	
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


