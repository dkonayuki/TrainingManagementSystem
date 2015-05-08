package com.rakuten.PenguinSoldiers.models.training;

//import java.security.Timestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.lang.String;



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
	//@Column(length=1023)
    @Lob
	private String overview;
	private int max_participants;
    private Timestamp due_date;
    private Timestamp start_date;
    private String status;
	
	public Training() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public int getMax_participants() {
		return max_participants;
	}

	public void setMax_participants(int max_participants) {
		this.max_participants = max_participants;
	}

	public Timestamp getDue_date() {
		return due_date;
	}

	public void setDue_date(Timestamp due_date) {
		this.due_date = due_date;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	


}


