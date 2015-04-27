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
}
