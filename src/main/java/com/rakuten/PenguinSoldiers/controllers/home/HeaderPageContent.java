package com.rakuten.PenguinSoldiers.controllers.home;

public class HeaderPageContent {

	private boolean isAdmin = false, isManager = false;

	public static String HOME_LABEL = "home";
	public static String TRAINING_LABEL = "training";
	public static String ACCOUNT_LABEL = "account";
	public static String MODE_LABEL = "mode";
	
	public static String AVAILABLE_LABEL = "available";
	public static String REGISTERED_LABEL = "own";

	private String activeLabel = "";

	private String accountName;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public void setActiveLabel(String label) {
		this.activeLabel = label;
	}

	public String getActiveLabel() {
		return this.activeLabel;
	}

	public boolean isActiveLabel(String label) {
		return this.getActiveLabel().equals(label);
	}

	public String showActiveLabel(String label) {
		return this.isActiveLabel(label) ? "active" : "";
	}
	
}
