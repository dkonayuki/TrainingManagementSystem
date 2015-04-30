package com.rakuten.PenguinSoldiers.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninController {

	@RequestMapping(value = "signin")
	public String signin() {
        return "signin/signin";
    }
	
	//@RequestMapping(value = "forgetPassword")
	//public String forgetPassword()
	//{
	//	return "signin/forgetPassword";
	//}
}
