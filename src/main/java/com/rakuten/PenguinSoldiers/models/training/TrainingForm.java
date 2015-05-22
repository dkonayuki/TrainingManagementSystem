package com.rakuten.PenguinSoldiers.models.training;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;

/** Class for handling request for adding new training */
public class TrainingForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String INVALID_DATE_MESSAGE = "{invalidDate.message}";
	private static final String INVALID_INTEGER_MESSAGE = "{invalidInteger.message}";

	public static final String STATUS_OPEN = "open";
	public static final String STATUS_CLOSED = "closed";
	public static final String STATUS_ALMOST = "almost";

    @Size(min = 0, max = 255, message = "Name must be between 1 and 255 characters")
	private String name;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String overview;
	private List<String> goals;
	private List<String> outlines;
	private String premise;

	private String date;
	private String targetPeople;
	@NotEmpty(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String participantNumber;

	private String dueDate;
	@NotEmpty(message = "Please enter Venue.")
	private String venue;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String status;

	public TrainingForm() {
		goals = new ArrayList<String>();
		outlines = new ArrayList<String>();
		//goals.add("");
		//outlines.add("");
	}

	public TrainingForm(Training training) {
		this.name = training.getName();
		this.overview = training.getOverview();
		this.premise = training.getPremise();
		this.venue = training.getVenue();
		this.dueDate = new SimpleDateFormat("dd/MM/yyyy, HH:mm").format(training.getDue_date());
		this.date = new SimpleDateFormat("dd/MM/yyyy, HH:mm").format(training.getStart_date());
		this.goals = training.getGoals();
		if (this.goals.isEmpty()) {
			this.goals.add("");
		}
		this.outlines = training.getOutlineListStr();
		
		System.out.println(this.outlines);
		this.targetPeople = training.getTarget();
		this.participantNumber = String.valueOf(training.getMax_participants());
		this.status = training.getStatus();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return this.overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public List<String> getGoals() {
		return this.goals;
	}

	public void setGoals(List<String> goals) {
		this.goals = goals;
	}

	public List<String> getOutlines() {
		return this.outlines;
	}

	public void setOutlines(List<String> outlines) {
		this.outlines = outlines;
	}

	public String getPremise() {
		return this.premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTargetPeople() {
		return this.targetPeople;
	}

	public void setTargetPeople(String targetPeople) {
		this.targetPeople = targetPeople;
	}

	public String getParticipantNumber() {
		return this.participantNumber;
	}

	public void setParticipantNumber(String participantNumber) {
		this.participantNumber = participantNumber;
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getVenue() {
		return this.venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static TrainingForm createForm(Training training) {
		TrainingForm tf = new TrainingForm(training);
		return tf;
	}

	public Training createTraining(AccountRepository accountRepository) {
		Training tr = new Training(name, overview, participantNumber);
		tr.setTarget(targetPeople);
		tr.setGoal(goals.toString());
		tr.setOutline(outlines.toString());
		tr.setVenue(venue);
		tr.setPremise(premise);
		tr.setStatus(status);

		// convert string date to DateTime
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		Date start_date = null, due_date = null;
		try {
			start_date = format.parse(date);
			due_date = format.parse(dueDate);
		} catch (ParseException e) {

			System.out.println("Parse error " + e.getMessage());
			return null;
		}
		tr.setDue_date(new Timestamp(due_date.getTime()));
		tr.setStart_date(new Timestamp(start_date.getTime()));

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		Account user = accountRepository.findByEmail(userDetails.getUsername());
		tr.setAdmin(user);

		return tr;

	}

	public String toString() {
		return "name:" + name + ", overview:" + overview + ", goals:"
				+ goals.toString() + ", outline:" + outlines.toString()
				+ ", premise:" + premise + ", date:" + date + ", targetPeople:"
				+ targetPeople + ", participantnumber:" + participantNumber
				+ ", duedate:" + dueDate + ", venue:" + venue + ", status:"
				+ status;
	}
}
