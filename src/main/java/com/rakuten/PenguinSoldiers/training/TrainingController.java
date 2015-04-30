package com.rakuten.PenguinSoldiers.training;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrainingController {
	
	@RequestMapping(value = "trainings", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
    // Here we are returning a collection of Training objects
		//List<Training> trainings = new ArrayList();
		model.addAttribute("test", "aa");
		//model.addAttribute("messages", accountRepository.findAll());
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
