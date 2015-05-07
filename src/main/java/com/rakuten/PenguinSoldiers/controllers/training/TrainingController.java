package com.rakuten.PenguinSoldiers.controllers.training;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rakuten.PenguinSoldiers.models.account.Account;

@Controller
public class TrainingController {
	
	@RequestMapping(value = "trainings", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
    // Here we are returning a collection of Training objects
		//List<Training> trainings = new ArrayList();
		Account acc = new Account("aa@aa", "aa", "admin");
		model.addAttribute("test", acc);
		return "training/trainingHome";
	}

	/*@RequestMapping(value = "message", method = RequestMethod.GET)
	public String messages(Model model) {
	    model.addAttribute("messages", messageRepository.findAll());
	    return "message/list";
	}*/

	@RequestMapping(value = "trainings/{id}", method = RequestMethod.GET)
	public String show(Principal principal) {
		return "training/details";
	}
	
}
