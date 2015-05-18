package com.rakuten.PenguinSoldiers.controllers.home;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;

@Controller
public class HomeController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TrainingService trainingService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
		if (principal != null) {
//			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
//			Account user = accountRepository.findByEmail(userDetails.getUsername());
//			model.addAttribute("trainings", user.getTrainings());
		  model.addAttribute("trainings", trainingService.findActiveTraining());
			return "home/homeSignedIn";
		}
		return "account/signin";
	}
}
