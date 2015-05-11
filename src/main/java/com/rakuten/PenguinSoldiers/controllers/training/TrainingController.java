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
import org.springframework.web.bind.annotation.*;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;

@Controller
public class TrainingController {
	
	@Autowired
  private TrainingService trainingService;
	
	@Autowired
	private AccountRepository accountRepository;
	
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

	
}
