package com.rakuten.PenguinSoldiers.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rakuten.PenguinSoldiers.account.AccountRepository;
import com.rakuten.PenguinSoldiers.entity.User;
import com.rakuten.PenguinSoldiers.repository.UserRepository;

@Controller
public class SigninController {
  
  @Autowired
  private UserRepository ur;
  
  
	@RequestMapping(value = "signin")
	public String signin() {
	  
	  
	  try{
	  User user=new User();
	  user.setEmail("michael@tan.com");
	  user.setName("Micahel");
	  user.setRole(new Long(1));
	  user.setPassword("hellowordl");
	  
	  ur.save(user);
	  }catch(Exception e){
	    e.printStackTrace();
	  }
	  
        return "signin/signin";
    }
}
