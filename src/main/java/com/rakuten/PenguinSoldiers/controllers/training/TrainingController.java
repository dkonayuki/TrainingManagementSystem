package com.rakuten.PenguinSoldiers.controllers.training;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.UserService;
import com.rakuten.PenguinSoldiers.models.goal.Goal;
import com.rakuten.PenguinSoldiers.models.outline.Outline;
import com.rakuten.PenguinSoldiers.models.premise.Premise;
import com.rakuten.PenguinSoldiers.models.target.Target;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;
import com.rakuten.PenguinSoldiers.models.venue.Venue;

@Controller
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "trainings", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
		// Here we are returning a collection of Training objects
		List<Training> trainings = trainingService.findAll();

		model.addAttribute("trainings", trainings);
		return "training/index";
	}

	/*@RequestMapping(value = "message", method = RequestMethod.GET)
	public String messages(Model model) {
	    model.addAttribute("messages", messageRepository.findAll());
	    return "message/list";
	}*/

	/*Training a = this.trainingService.findById(3);
	a.setName("new");
	trainingService.update(a);*/
	//Training a = new Training("up");
	//trainingService.save(a);
	//trainingService.delete(5);

	@RequestMapping(value = "trainings/{id}", method = RequestMethod.GET)
	public String show(Principal principal, Model model, @PathVariable Integer id) {
		Training training = this.trainingService.findById(id);
		model.addAttribute(training);

		return "training/show";
	}

	@RequestMapping(value = "trainings/new", method=RequestMethod.GET)
	public String addTrainingPrograms() {
		return "training/new";
	}

	@RequestMapping(value = "trainings", method = RequestMethod.POST)
	public String addAction(@RequestParam("name") String name, @RequestParam("overview") String overview, 
			@RequestParam("goal") String goal, @RequestParam("date") String date, @RequestParam("target") String target, 
			@RequestParam("participantNum") String participantNum, @RequestParam("duedate") String duedate, 
			@RequestParam("venue") String venue, @RequestParam("outline") String outline,
			@RequestParam("premise") String premise, ModelMap model)
	{
		// create new training program item
		Training tr = new Training(name);
		tr.setOverview(overview);
		tr.setMax_participants(participantNum);
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Account user = accountRepository.findByEmail(userDetails.getUsername());
		tr.setAdmin(user);
		trainingService.save(tr);
		/*
		Long training_id = tr.getId();

		// add training goal
		Goal gl = new Goal(goal);
		gl.setTraining_id(training_id);

		// add training outline
		Outline ol = new Outline(outline);
		ol.setTraining_id(training_id);

		// add training premise
		Premise pr = new Premise(premise);
		pr.setTraining_id(training_id);

		// add training target people
		Target ta = new Target(target);
		ta.setTraining_id(training_id);

		// add training venue info
		Venue ve = new Venue(venue);
		ve.setTraining_id(training_id);
*/
		//return to home
		//return "redirect:/";
		return "redirect:trainings/" + tr.getId();
	}

}
