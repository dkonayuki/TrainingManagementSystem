package com.rakuten.PenguinSoldiers.signin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgotPasswordController {

	@RequestMapping(value = "forgotPassword", method=RequestMethod.GET)
	public String forgotPassword()
	{
		return "signin/forgotPassword";
	}



}
