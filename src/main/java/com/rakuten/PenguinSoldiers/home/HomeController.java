package com.rakuten.PenguinSoldiers.home;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
	public static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
		
		logger.info("Entry made to HomeController");
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
