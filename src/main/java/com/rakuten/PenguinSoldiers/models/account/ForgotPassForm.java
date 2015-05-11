package com.rakuten.PenguinSoldiers.models.account;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class ForgotPassForm {
	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = ForgotPassForm.NOT_BLANK_MESSAGE)
	@Email(message = ForgotPassForm.EMAIL_MESSAGE)
	private String email;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
