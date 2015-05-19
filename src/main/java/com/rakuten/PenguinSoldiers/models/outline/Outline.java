package com.rakuten.PenguinSoldiers.models.outline;

public class Outline {

	private String date;
	private String text;

	public Outline(String date, String text) {
		this.date = date;
		this.text = text;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
