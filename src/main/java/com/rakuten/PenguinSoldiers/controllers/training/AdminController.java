package com.rakuten.PenguinSoldiers.controllers.training;

import javax.persistence.Lob;
import javax.validation.Valid;

import java.sql.Blob;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;
import com.rakuten.PenguinSoldiers.models.training.Goal;
import com.rakuten.PenguinSoldiers.models.training.GoalService;
import com.rakuten.PenguinSoldiers.models.training.Outline;
import com.rakuten.PenguinSoldiers.models.training.OutlineService;
import com.rakuten.PenguinSoldiers.models.training.Premise;
import com.rakuten.PenguinSoldiers.models.training.PremiseService;
import com.rakuten.PenguinSoldiers.models.training.Target;
import com.rakuten.PenguinSoldiers.models.training.TargetService;
import com.rakuten.PenguinSoldiers.models.training.Venue;
import com.rakuten.PenguinSoldiers.models.training.VenueService;



import java.lang.String;

@Controller
public class AdminController {
	@Autowired
	private TrainingService trainingService;
	@Autowired	
	private GoalService goalService;
    @Autowired
    private OutlineService outlineService;
	@Autowired
	private PremiseService premiseService;
	@Autowired
	private TargetService targetService;
	@Autowired
	private VenueService venueService;
    
	@RequestMapping(value = "addTrainingPrograms", method=RequestMethod.GET)
	public String addTrainingPrograms()
	{
		return "admin/addTrainingPrograms";
	}

	@Lob
	private String overview;
	@RequestMapping(value = "addAction", method = RequestMethod.GET)
	/*public String addAction(@Valid @ModelAttribute Training Training)
	{
		String Name = Training.getName();
		Training tr = new Training(Name);
		//tr.setOverview(overview);
		trainingService.save(tr);
		return "home/homeSignedIn";
	}*/
	public String addAction(@RequestParam("name") String Name, @RequestParam("overview") String overview, 
			                @RequestParam("goal") String goal, @RequestParam("date") String date, @RequestParam("target") String target, 
			                @RequestParam("participantNum") int participantNum, @RequestParam("duedate") String duedate, 
			                @RequestParam("venue") String venue, @RequestParam("outline") String outline,
			                @RequestParam("premise") String premise, ModelMap model)
	{
		// create new training program item
		Training tr = new Training(Name);
		tr.setOverview(overview);
		tr.setMax_participants(participantNum);
		//tr.setDue_date(duedate);
		trainingService.save(tr);
		Long training_id = tr.getId();
		
		// add training goal
	    Goal gl = new Goal(goal);
		gl.setTraining_id(training_id);
		goalService.save(gl);
		
		// add training outline
		Outline ol = new Outline(outline);
		ol.setTraining_id(training_id);
		outlineService.save(ol);
		
		// add training premise
		Premise pr = new Premise(premise);
		pr.setTraining_id(training_id);
		premiseService.save(pr);
		
		// add training target people
		Target ta = new Target(target);
		ta.setTraining_id(training_id);
		targetService.save(ta);
	
		// add training venue info
		Venue ve = new Venue(venue);
		ve.setTraining_id(training_id);
		venueService.save(ve);
		
		return "home/homeSignedIn";
	}
}