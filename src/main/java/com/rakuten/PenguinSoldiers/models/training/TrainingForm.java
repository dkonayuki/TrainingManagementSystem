package com.rakuten.PenguinSoldiers.models.training;

import java.util.Date;

public class TrainingForm {

	private String name;
	private String overview;
	private String goal;
	private String outline;
	private String premise;
	private Date date;
	private String targetPeople;
	private Integer participantNumber;
	private Date dueDate;
	private String venue;

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

    public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

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

    public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
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

    public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

    public String getVenue() {
		return this.venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
}
