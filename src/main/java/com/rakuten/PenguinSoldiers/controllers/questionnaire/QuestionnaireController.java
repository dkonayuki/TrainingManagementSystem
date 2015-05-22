package com.rakuten.PenguinSoldiers.controllers.questionnaire;

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
import com.rakuten.PenguinSoldiers.models.venue.Venue;
import com.rakuten.PenguinSoldiers.util.ControllerUtil;

@Controller
public class QuestionnaireController {
	
	@RequestMapping(value = "questionnairetest", method = RequestMethod.GET)
	public String question(Principal principal, Model model) {
		// Here we are returning a collection of Training objects
		
		//List<Training> trainings = trainingService.findActiveTraining();

		//List<Training> trainings = trainingService.findAll();
		
		//model.addAttribute("questionnairetest", trainings);

		return "training/Questionnaire";
	}
}