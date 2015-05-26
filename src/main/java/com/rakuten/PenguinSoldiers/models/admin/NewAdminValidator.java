package com.rakuten.PenguinSoldiers.models.admin;

import org.springframework.validation.Errors;

import com.rakuten.PenguinSoldiers.models.account.Account;

public class NewAdminValidator {

	public void validate(Account newAccount, Errors errors) {
		
		if(newAccount==null)
		{
			errors.rejectValue("newAdminId","newAdmin.invalid");
		}
		else
		{
			System.out.println("Valid new Admin");
		}
	}
}
