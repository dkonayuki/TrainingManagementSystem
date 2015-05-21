package com.rakuten.PenguinSoldiers.controllers.training;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rakuten.PenguinSoldiers.controllers.home.HeaderPageContentBuilder;
import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.SignupForm;
import com.rakuten.PenguinSoldiers.models.account.UserService;
import com.rakuten.PenguinSoldiers.models.admin.AdminRepository;
import com.rakuten.PenguinSoldiers.models.goal.Goal;
import com.rakuten.PenguinSoldiers.models.goal.GoalService;
import com.rakuten.PenguinSoldiers.models.outline.Outline;
import com.rakuten.PenguinSoldiers.models.premise.Premise;
import com.rakuten.PenguinSoldiers.models.target.Target;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingForm;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;
import com.rakuten.PenguinSoldiers.models.training.TrainingValidator;
import com.rakuten.PenguinSoldiers.models.venue.Venue;
import com.rakuten.PenguinSoldiers.util.ControllerUtil;

@Controller
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "trainings", method = RequestMethod.GET)
	public String index(@RequestParam(value = "name", required = false) String name, Principal principal, Model model) {
		// Here we are returning a collection of Training objects
		
		//List<Training> trainings = trainingService.findActiveTraining();
		List<Training> trainings;
		if (name == null) {
			trainings = trainingService.findAll();
		} else {
			trainings = trainingService.findByName(name);
		}
		model.addAttribute("trainings", trainings);

		return "training/index";
	}
	
	@RequestMapping(value = "trainings", method = {RequestMethod.GET, RequestMethod.HEAD},     
	    headers = "x-requested-with=XMLHttpRequest")
	public String search(@RequestParam(value = "name") String name, Model model) {
		List<Training> tl = trainingService.findByName(name);
		model.addAttribute("trainings", tl);
		return "training/_training_list";
	}

	@RequestMapping(value = "trainings/{id}", method = RequestMethod.GET)
	public String show(Principal principal, Model model,
			@PathVariable Integer id) {
		Training training = this.trainingService.findById(id);
		// convert training in
		model.addAttribute(training);
		
		return "training/show";
	}
	
	@RequestMapping(value = "trainings/{id}/edit", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id) {
		Training training = this.trainingService.findById(id);
		model.addAttribute("trainingForm", TrainingForm.createForm(training));
		model.addAttribute("training", training);

		return "training/edit";
	}
	
	@RequestMapping(value = "trainings/{id}", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute TrainingForm trainingForm,
			Errors errors, final Model model, RedirectAttributes ra, @PathVariable Integer id) {
		Training training = this.trainingService.findById(id);
		Training tr = trainingForm.createTraining(accountRepository);
		
		training.copy(tr);
		
		trainingService.update(training);

		return "redirect:/trainings/" + training.getId();
	}
	
	@RequestMapping(value = "trainings/new", method = RequestMethod.GET)
	public String addTrainingPrograms(Model model) {
		model.addAttribute("trainingForm", new TrainingForm());
		return "training/new";
	}
	
	@RequestMapping(value = "trainings/{id}", produces="text/html", method = RequestMethod.DELETE)
	@ResponseBody
	public String destroy(@PathVariable Integer id) {
		System.out.println(id);
		
		trainingService.delete(id);
		return "redirect:trainings";
	}

	/*
	@RequestMapping(value = "trainings", method = RequestMethod.POST)
	public String addAction(@Valid @ModelAttribute TrainingForm trainingForm,
			Errors errors, final Model model, RedirectAttributes ra) {		
		
		if (errors.hasErrors()) {
			if(trainingForm.getGoals().size() < 1) 
				trainingForm.getGoals().add("");
			if(trainingForm.getOutlines().size() < 1) 
				trainingForm.getOutlines().add("");
			model.addAttribute("trainingForm", trainingForm);
			// ra.addFlashAttribute("trainingForm", trainingForm);
			return "training/new";
		}

		System.out.println(trainingForm.toString());

		// create new training program item
		Training tr = trainingForm.createTraining(accountRepository);
		if (tr == null) {
			model.addAttribute("trainingForm", trainingForm);
			return "training/new";
		}
		
		trainingService.save(tr);
		return "redirect:/trainings/" + tr.getId();
	}*/
	@RequestMapping(value = "trainings", method = RequestMethod.POST)
	public String addAction(@Valid @ModelAttribute TrainingForm trainingForm, BindingResult result, final Model model, Errors errors) {		
		
		TrainingValidator trainingValidator = new TrainingValidator();
		trainingValidator.validate(trainingForm, result);
		if (result.hasErrors() || errors.hasErrors()) {
			return "training/new";
		}

		System.out.println(trainingForm.toString());

		// create new training program item
		Training tr = trainingForm.createTraining(accountRepository);
		if (tr == null) {
			model.addAttribute("trainingForm", trainingForm);
			return "training/new";
		}
		
		trainingService.save(tr);
		return "redirect:/trainings/" + tr.getId();
	}

}
