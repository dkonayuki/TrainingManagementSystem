package com.rakuten.PenguinSoldiers.controllers.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;



@Controller
public class AdminController {
	@Autowired
	private TrainingService trainingService;
	
	@RequestMapping(value = "addTrainingPrograms", method=RequestMethod.GET)
	public String addTrainingPrograms()
	{
		return "admin/addTrainingPrograms";
	}

	@RequestMapping(value = "addAction", method = RequestMethod.GET)
	public String addAction(@RequestParam("name") String Name, ModelMap model)
	{
		System.out.println(Name);
		Training tr = new Training(Name);
		trainingService.save(tr);
		return "home/homeSignedIn";
	}
}


