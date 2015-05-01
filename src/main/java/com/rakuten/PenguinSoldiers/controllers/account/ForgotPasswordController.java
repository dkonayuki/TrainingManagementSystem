package com.rakuten.PenguinSoldiers.controllers.account;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotPasswordController {

	@RequestMapping(value = "forgotPass", method = RequestMethod.GET)
	public String forgotPass(Principal principal) {
		return "account/forgotPass";
	}

}
