package com.rakuten.PenguinSoldiers.controllers.account;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

	@RequestMapping(value = "signin") 
	public String signin() {
		return "account/signin";
	}
	
}
