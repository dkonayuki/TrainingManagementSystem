package com.rakuten.PenguinSoldiers.controllers.account;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SigninController {

	@RequestMapping(value = "signin") 
	public String signin() {
		return "account/signin";
	}
	
	@RequestMapping(value = "signinError") 
  public String signin(@RequestParam("error") String error, Model model) {
    return "account/signin";
  }
  
}
