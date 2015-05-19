package com.rakuten.PenguinSoldiers.controllers.home;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.admin.AdminRepository;

public class HeaderPageContentBuilder {

	public static HeaderPageContent build(AccountRepository ar,
			AdminRepository adR, String username) {
		return HeaderPageContentBuilder.build(ar, adR, username,
				HeaderPageContent.HOME_LABEL);
	}

	public static HeaderPageContent build(AccountRepository ar,
			AdminRepository adR, String username, String servletName) {
		Account a = ar.findByUsername(username);
		HeaderPageContent hpc = new HeaderPageContent();
		if (a != null) {
			hpc.setAdmin(adR.isAdmin(a.getId()));
			hpc.setManager(ar.isManager(a.getUsername()));
			hpc.setAccountName(a.getName());
		}
		String headerLabel = HeaderPageContentBuilder
				.convertServletNameToHeaderLabel(servletName);
		hpc.setActiveLabel(headerLabel);

		return hpc;
	}

	public static String convertServletNameToHeaderLabel(String servletName) {
		if (servletName.equals("/trainings"))
			return HeaderPageContent.TRAINING_LABEL;
		else if (servletName.startsWith("/account/wantChangePass")
				|| servletName.startsWith("/account/changePass"))
			return HeaderPageContent.ACCOUNT_LABEL;
		else if (servletName.startsWith("/admin")
				|| servletName.startsWith("/manage")
				|| servletName.startsWith("/trainings/new"))
			return HeaderPageContent.MODE_LABEL;
		return HeaderPageContent.HOME_LABEL;
	}
}
