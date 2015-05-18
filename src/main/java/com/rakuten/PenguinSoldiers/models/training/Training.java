package com.rakuten.PenguinSoldiers.models.training;

//import java.security.Timestamp;

import javax.persistence.*;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.goal.Goal;
import com.rakuten.PenguinSoldiers.models.outline.Outline;
import com.rakuten.PenguinSoldiers.models.premise.Premise;
import com.rakuten.PenguinSoldiers.models.target.Target;
import com.rakuten.PenguinSoldiers.models.venue.Venue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;



@SuppressWarnings("serial")
@Entity
@Table(name = "training")
@NamedQueries({
@NamedQuery(name = Training.FIND_ACTIVE_TRAINING, query = "select a from Training a where a.start_date >= now()"),
@NamedQuery(name = Training.FIND_BY_ID, query = "select a from Training a where a.id = :id"),
@NamedQuery(name = Training.FIND_REGISTERED_TRAINING, query = "select a from Training a, TrainingUser tu where a.start_date >= now() and a.id = tu.trainingId and tu.userId=:id"),
@NamedQuery(name = Training.FIND_NOT_REGISTERED_TRAINING, query = "select a from Training a where a.start_date >= now() and a.id not in ( select tu.trainingId from TrainingUser tu where tu.userId=:id)")
})
public class Training implements java.io.Serializable {

	public static final String FIND_BY_ID = "Training.findById";
	public static final String FIND_ACTIVE_TRAINING= "Training.findActiveTraining";
	public static final String FIND_REGISTERED_TRAINING= "Training.findRegisteredTraining";
	public static final String FIND_NOT_REGISTERED_TRAINING= "Training.findNotRegisteredTraining";
	
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "admin_id")
  private Account admin;
	
	@Lob
	private String target;
	@Lob
	private String premise;
	@Lob
	private String outline;
	@Lob
	private String goal;
	@Lob
	private String venue;
	
	/*
	@OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Target> targets;
	
	@OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Premise> premises;
	
	@OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Outline> outlines;
	
	@OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Goal> goals;
	
	@OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Venue> venues;*/
	
	/*@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
  @JoinTable(name="account_training", 
      joinColumns={@JoinColumn(name="training_id")},
      inverseJoinColumns={@JoinColumn(name="account_id")})
	public List<Account> participants;*/

	private String name;
	//@Column(length=1023)
	@Lob
	private String overview;
	private int max_participants;
	private Timestamp due_date;
	private Timestamp start_date;
	private String status;

	protected Training() {
	}

	public Training(String name, String overview, String participantNum) {
		this.name = name;
		this.overview = overview;
		
		if (participantNum.isEmpty()) {
			this.max_participants = 0;
		} else {
			this.max_participants = Integer.parseInt(participantNum);
		}
		/*
		this.goals = new ArrayList<Goal>();
		this.outlines = new ArrayList<Outline>();
		this.venues = new ArrayList<Venue>();
		this.targets = new ArrayList<Target>();
		this.premises = new ArrayList<Premise>();
		*/
	}
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getPremise() {
		return premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Integer getId() {
		return id;
	}
	/*
	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
	
	public List<Premise> getPremises() {
		return premises;
	}

	public void setPremises(List<Premise> premises) {
		this.premises = premises;
	}

	public List<Outline> getOutlines() {
		return outlines;
	}

	public void setOutlines(List<Outline> outlines) {
		this.outlines = outlines;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
	
	public void addGoal(Goal goal) {
		this.goals.add(goal);
	}

	public List<Venue> getVenues() {
		return venues;
	}

	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}
	*/

	public Account getAdmin() {
		return admin;
	}

	public void setAdmin(Account admin) {
		this.admin = admin;
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
	
	public void setMax_participants(String max_participants) {
		this.max_participants = Integer.parseInt(max_participants);
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

	public void copy(Training tr) {
		this.due_date = tr.due_date;
		this.start_date = tr.start_date;
		this.goal = tr.goal;
		this.max_participants = tr.max_participants;
		this.name = tr.name;
		this.premise = tr.premise;
		this.overview = tr.overview;
		this.venue = tr.venue;
	}

}


