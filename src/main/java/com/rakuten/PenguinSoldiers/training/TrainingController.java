package com.rakuten.PenguinSoldiers.training;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrainingController {
	
	@RequestMapping(value = "trainings", method = RequestMethod.GET)
	public String index(Principal principal) {
		return "training/trainingHome";
	}

	@RequestMapping(value = "trainings/{id}", method = RequestMethod.GET)
	public String show(Principal principal) {
		return "training/details";
	}
	
	@RequestMapping(value = "trainingList", method = RequestMethod.GET)
	public String trainingList(Principal principal) {
		return "training/trainingList";
	}

}
