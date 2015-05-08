package com.rakuten.PenguinSoldiers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@RequestMapping(value = "addTrainingPrograms", method=RequestMethod.GET)
	public String forgotPassword()
	{
		return "admin/addTrainingPrograms";
	}

	@RequestMapping(value = "/addAction", method = RequestMethod.POST)
	public String addAction(@RequestParam("name") String Name, Model model)
	{
		System.out.println(Name);
		return null;
	}
}
