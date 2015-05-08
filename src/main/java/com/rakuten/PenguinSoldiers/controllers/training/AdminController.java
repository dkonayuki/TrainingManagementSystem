package com.rakuten.PenguinSoldiers.controllers.training;

import javax.persistence.Lob;
import java.sql.Blob;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;


import java.lang.String;

@Controller
public class AdminController {
	@Autowired
	private TrainingService trainingService;
	
	@RequestMapping(value = "addTrainingPrograms", method=RequestMethod.GET)
	public String addTrainingPrograms()
	{
		return "admin/addTrainingPrograms";
	}

	@Lob
	private String overview;
	@RequestMapping(value = "addAction", method = RequestMethod.GET)
	public String addAction(@RequestParam("name") String Name, @RequestParam("overview") String overview, @RequestParam("goal") String goal, @RequestParam("date") String date, @RequestParam("target") String target, @RequestParam("participantNum") int participantNum, @RequestParam("duedate") String duedate, @RequestParam("venue") String venue, ModelMap model)
	{
		Training tr = new Training();
		tr.setName(Name);
		tr.setOverview(overview);
		tr.setMax_participants(participantNum);
		//tr.setDue_date(duedate);
		trainingService.save(tr);
		return "home/homeSignedIn";
	}
}
