package com.rakuten.PenguinSoldiers.controllers.home;

import java.util.HashMap;

public class HeaderPageContent {
	
		private boolean isAdmin = false, isManager = false;
		
		public static String HOME_LABEL = "home";
		public static String TRAINING_LABEL = "training";
		public static String ACCOUNT_LABEL = "account";
		public static String MODE_LABEL = "mode";
		
		public static String AVAILABLE_LABEL = "available";
		public static String REGISTERED_LABEL = "own";
		
		/* navigation labels */
		public static final String AVAIL_TRAINING_LBL = "filter_out";
		public static final String REGIS_TRAINING_LBL = "filter_in";
		public static final String ADM_NEW_TRAINING_LBL = "admin_new";
		public static final String ADM_ADD_TRAINING_LBL = "admin_add";
		public static final String MGR_APP_TRAINING_LBL = "manager_apply";
		
		private String activeLabel = "";
		
		private String accountName;

		public static HashMap<String, String> maP;
		
		public HeaderPageContent() {
			maP = new HashMap<String, String>();
			maP.put("filter=out", AVAIL_TRAINING_LBL);
			maP.put("filter=in", REGIS_TRAINING_LBL);
			maP.put("/trainings/new", ADM_NEW_TRAINING_LBL);
			maP.put("/admin/addAdminPage", ADM_ADD_TRAINING_LBL);
			maP.put("/manager/manage", MGR_APP_TRAINING_LBL);
		}
		
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
