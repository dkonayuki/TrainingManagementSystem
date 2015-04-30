package com.rakuten.PenguinSoldiers.signin;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rakuten.PenguinSoldiers.home.HomeController;

@Controller
public class ForgotPasswordController {

	public static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = "forgotPass", method = RequestMethod.GET)
	public String forgotPass(Principal principal) {
		
		logger.info("Entry made for forgotPass");
		return "signin/forgotPass";
	}

}
