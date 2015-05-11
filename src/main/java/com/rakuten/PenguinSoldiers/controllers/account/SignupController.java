package com.rakuten.PenguinSoldiers.controllers.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rakuten.PenguinSoldiers.support.web.*;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.SignupForm;
import com.rakuten.PenguinSoldiers.models.account.UserService;
import com.rakuten.api.users.JsonUserParser;

@Controller
public class SignupController {

	private static final String SIGNUP_VIEW_NAME = "account/signup";
	private static final String COMPANY_DOMAIN = "rakuten.com";

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "signup")
	public String signup(Model model) {
		model.addAttribute(new SignupForm());
		return SIGNUP_VIEW_NAME;
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm,
			Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return SIGNUP_VIEW_NAME;
		}
		
		// TODO: add email validator

		/** Validate the user here (with json API) */
		String email = signupForm.getEmail();
		String[] parts = email.split("@");
		if(parts.length < 2) return SIGNUP_VIEW_NAME; // no at_mark
		String username = parts[0];
		String domain = parts[1];
		
		if(!domain.equals(COMPANY_DOMAIN)) { // not a rakuten.com email
			return SIGNUP_VIEW_NAME;
		}
		
		JsonUserParser userparser = new JsonUserParser();
		try {
			userparser.getAccountByUsername(username);			
		} catch (Exception e) {
			System.out.println("User does not exist");
			return SIGNUP_VIEW_NAME;
		} finally {
			System.out.println("User exists adding");
		}

		// Save to repository
		Account account = accountRepository.save(signupForm.createAccount());
		userService.signin(account);
		// see /WEB-INF/i18n/messages.properties and
		// /WEB-INF/views/homeSignedIn.html
		MessageHelper.addSuccessAttribute(ra, "signup.success");
		return "redirect:/";
	}
}
