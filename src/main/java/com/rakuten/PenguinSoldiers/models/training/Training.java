package com.rakuten.PenguinSoldiers.models.training;

//import java.security.Timestamp;

import javax.persistence.*;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.goal.Goal;
import com.rakuten.PenguinSoldiers.models.outline.Outline;
import com.rakuten.PenguinSoldiers.models.premise.Premise;
import com.rakuten.PenguinSoldiers.models.target.Target;
import com.rakuten.PenguinSoldiers.models.venue.Venue;

import org.json.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import java.net.URLDecoder;

@SuppressWarnings("serial")
@Entity
@Table(name = "training")
@NamedQueries({
@NamedQuery(name = Training.FIND_ALL_TRAINING, query = "select a from Training a where a.name like :name order by a.due_date asc"),
@NamedQuery(name = Training.FIND_ACTIVE_TRAINING, query = "select a from Training a where a.name like :name"),
@NamedQuery(name = Training.FIND_BY_ID, query = "select a from Training a where a.id = :id"),
@NamedQuery(name = Training.FIND_REGISTERED_TRAINING, query = "select a from Training a, TrainingUser tu where a.name like :name and a.due_date > now() and a.id = tu.trainingId and tu.userId=:id order by a.due_date desc"),
@NamedQuery(name = Training.FIND_PAST_REGISTERED_TRAINING, query = "select a from Training a, TrainingUser tu where a.id = tu.trainingId and a.name like :name and tu.userId=:id and a.due_date < now() order by a.due_date  desc"),
@NamedQuery(name = Training.FIND_NOT_REGISTERED_TRAINING, query = "select a from Training a where a.name like :name and a.id not in ( select tu.trainingId from TrainingUser tu where tu.userId=:id) order by a.due_date  desc"),
@NamedQuery(name = Training.FIND_BY_NAME, query = "select a from Training a where a.name LIKE :name")
})
public class Training implements java.io.Serializable {

	public static final String FIND_BY_ID = "Training.findById";
	public static final String FIND_ALL_TRAINING = "Training.findAllTraining";
	public static final String FIND_ACTIVE_TRAINING = "Training.findActiveTraining";
	public static final String FIND_REGISTERED_TRAINING = "Training.findRegisteredTraining";
	public static final String FIND_PAST_REGISTERED_TRAINING = "Training.findPastRegisteredTraining";
	public static final String FIND_NOT_REGISTERED_TRAINING = "Training.findNotRegisteredTraining";
	public static final String FIND_BY_NAME = "Training.findByName";

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
	 * @OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<Target> targets;
	 * 
	 * @OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<Premise> premises;
	 * 
	 * @OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<Outline> outlines;
	 * 
	 * @OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<Goal> goals;
	 * 
	 * @OneToMany(mappedBy = "training", fetch=FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<Venue> venues;
	 */

	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	 * 
	 * @JoinTable(name="account_training",
	 * joinColumns={@JoinColumn(name="training_id")},
	 * inverseJoinColumns={@JoinColumn(name="account_id")}) public List<Account>
	 * participants;
	 */

	private String name;
	// @Column(length=1023)
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
		 * this.goals = new ArrayList<Goal>(); this.outlines = new
		 * ArrayList<Outline>(); this.venues = new ArrayList<Venue>();
		 * this.targets = new ArrayList<Target>(); this.premises = new
		 * ArrayList<Premise>();
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
	 * public List<Target> getTargets() { return targets; }
	 * 
	 * public void setTargets(List<Target> targets) { this.targets = targets; }
	 * 
	 * public List<Premise> getPremises() { return premises; }
	 * 
	 * public void setPremises(List<Premise> premises) { this.premises =
	 * premises; }
	 * 
	 * public List<Outline> getOutlines() { return outlines; }
	 * 
	 * public void setOutlines(List<Outline> outlines) { this.outlines =
	 * outlines; }
	 */

	public List<String> getGoals() {
		List<String> goals = new ArrayList<String>();

		JSONArray jsonGoals = new JSONArray(this.getGoal());
		for (int i = 0; i < jsonGoals.length(); i++) {
			goals.add(jsonGoals.get(i).toString());
		}

		return goals;
	}

	public List<Outline> getOutlineList() {
		List<Outline> outline = new ArrayList<Outline>();
		String outlinesJsonString = URLDecoder.decode(URLDecoder.decode(this
				.getOutline()));
		String outlineDate, outlineText;

		JSONArray outlinesJson = new JSONArray(outlinesJsonString);
		JSONObject outlineJson;
		for (int i = 0; i < outlinesJson.length(); i++) {
			outlineJson = outlinesJson.getJSONObject(i);
			outlineDate = outlineJson.getString("outline-date");
			outlineText = outlineJson.getString("outline-text");
			outline.add(new Outline(outlineDate, outlineText));
		}

		return outline;
	}

	/**/
	public List<String> getOutlineListStr() {
		List<String> outlines = new ArrayList<String>();
		String outlinesJsonString = URLDecoder.decode(URLDecoder.decode(this
				.getOutline()));

		JSONArray outlinesJson = new JSONArray(outlinesJsonString);
		JSONObject outlineJson;
		for (int i = 0; i < outlinesJson.length(); i++) {
			outlineJson = outlinesJson.getJSONObject(i);
			outlines.add(outlineJson.toString());
		}

		return outlines;
	}

	/*
	 * 
	 * public void setGoals(List<Goal> goals) { this.goals = goals; }
	 * 
	 * public void addGoal(Goal goal) { this.goals.add(goal); }
	 * 
	 * public List<Venue> getVenues() { return venues; }
	 * 
	 * public void setVenues(List<Venue> venues) { this.venues = venues; }
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
		this.outline = tr.outline;
		this.max_participants = tr.max_participants;
		this.name = tr.name;
		this.premise = tr.premise;
		this.overview = tr.overview;
		this.venue = tr.venue;
	}

	public String getOverview(int length) {
		if (this.getOverview() == null)
			return null;
		if (this.getOverview().length() > length)
			return this.getOverview().substring(0, length);
		return this.getOverview();
	}

}
