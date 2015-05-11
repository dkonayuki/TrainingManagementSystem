package com.rakuten.PenguinSoldiers.controllers.account;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rakuten.PenguinSoldiers.models.account.ForgotPassForm;

@Controller
public class ForgotPasswordController {
	
	private static final String FPASS_VIEW_NAME = "account/forgotPass";
	private static final String SIGNIN_VIEW_NAME = "account/signin";

	@RequestMapping(value = "forgotPassword", method = RequestMethod.GET)
	public String forgotPass(Principal principal, Model model) {
		model.addAttribute(new ForgotPassForm());
		return FPASS_VIEW_NAME;
	}
	
	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute ForgotPassForm forgotPassForm,
			Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return FPASS_VIEW_NAME;
		}
		
		// TODO: send 'reset password' email 
		return "redirect:/" + SIGNIN_VIEW_NAME;
	}

}
