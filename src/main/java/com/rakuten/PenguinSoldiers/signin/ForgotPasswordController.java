package com.rakuten.PenguinSoldiers.signin;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotPasswordController {

	@RequestMapping(value = "forgotPass", method = RequestMethod.GET)
	public String forgotPass(Principal principal) {
		return "signin/forgotPass";
	}

}