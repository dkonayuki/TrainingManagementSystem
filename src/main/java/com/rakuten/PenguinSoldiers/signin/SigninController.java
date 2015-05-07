package com.rakuten.PenguinSoldiers.signin;


import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
public class SigninController {
  
	@RequestMapping(value = "signin")
	public String signin() {
    return "signin/signin";
  }
}
