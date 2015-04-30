package com.rakuten.PenguinSoldiers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value = "addTrainingPrograms", method=RequestMethod.GET)
	public String forgotPassword()
	{
		return "admin/addTrainingPrograms";
	}

}
