package com.rakuten.PenguinSoldiers.signin;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rakuten.PenguinSoldiers.home.HomeController;

@Controller
public class ForgotPasswordController {

	@RequestMapping(value = "forgotPassword", method = RequestMethod.GET)
	public String forgotPass(Principal principal) {
		return "signin/forgotPassword";
	}

}
