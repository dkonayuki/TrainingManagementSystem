package com.rakuten.PenguinSoldiers.models.training;

import org.hibernate.validator.constraints.*;
import java.util.Date;

public class TrainingForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String INVALID_DATE_MESSAGE = "{invalidDate.message}";
	private static final String INVALID_INTEGER_MESSAGE = "{invalidInteger.message}";

	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String name;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String overview;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String[] goal;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String outline;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String premise;
	/* @DateTimeFormat(style="S-",message=TrainingForm.INVALID_DATE_MESSAGE) */
	private Date date;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	private String targetPeople;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
	/* @RegExp("[0-9]+",message=TrainingForm.INVALID_INTEGER_MESSAGE) */
	private Integer participantNumber;
	/* @DateTimeFormat(style="S-",message=TrainingForm.INVALID_DATE_MESSAGE) */
	private Date dueDate;
	@NotBlank(message = TrainingForm.NOT_BLANK_MESSAGE)
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

    public String[] getGoal() {
		return this.goal;
	}

	public void setGoal(String[] goal) {
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
