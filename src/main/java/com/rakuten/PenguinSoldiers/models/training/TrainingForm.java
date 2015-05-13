package com.rakuten.PenguinSoldiers.models.training;

import java.util.ArrayList;
import java.util.List;

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

	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String name;
	// @NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String overview;
	// @NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private List<String> goals;
/*	// @NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String outline;
	// @NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String premise;
	private String date;
	//@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String targetPeople;
	//@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private Integer participantNumber;
	private String dueDate;
	//@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String[] venue;
	*/
	
	public TrainingForm() {
		goals = new ArrayList<String>();
		goals.add("");
		goals.add("test");
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

	/*
	public String getOutline() {
		return this.outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
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

	public Integer getParticipantNumber() {
		return this.participantNumber;
	}

	public void setParticipantNumber(Integer participantNumber) {
		this.participantNumber = participantNumber;
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String[] getVenue() {
		return this.venue;
	}

	public void setVenue(String[] venue) {
		this.venue = venue;
	}

*/
	public Training createTraining(AccountRepository accountRepository) {
		Training tr = new Training(name, overview, "13");
		//tr.setMax_participants(participantNumber);
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		Account user = accountRepository.findByEmail(userDetails.getUsername());
		tr.setAdmin(user);

		return tr;

	}

	public String toString() {
		return "name:" + name + ", overview:" + overview + ", goals:" + goals.toString();
				/* + ", outline:" + outline + ", premise:" + premise + ", date:" + date 
				+ ", targetPeople:" + targetPeople + ", participantnumber:" + participantNumber + ", duedate:" + dueDate
				+ ", venue:" + venue.toString(); */
	}
}
