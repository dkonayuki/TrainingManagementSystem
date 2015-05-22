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
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionaire;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionaireForm;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionaireRepository;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingForm;
import com.rakuten.PenguinSoldiers.models.training.TrainingRepository;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;
import com.rakuten.PenguinSoldiers.models.training.TrainingUserRepository;
import com.rakuten.PenguinSoldiers.models.venue.Venue;
import com.rakuten.PenguinSoldiers.util.ControllerUtil;
import com.rakuten.PenguinSoldiers.util.form.QuestionaireConverter;

@Controller
public class QuestionnaireController {
	
  @Autowired
  private TrainingRepository tr;
  
  @Autowired
  private TrainingUserRepository tur;
  
  @Autowired
  private AccountRepository ar;
  
  @Autowired
  private StandardQuestionaireRepository sqr;
  
	@RequestMapping(value = "feedback/form", method = RequestMethod.GET)
	public String question(@RequestParam("tId") String tId,Principal principal, Model model) {
	  
	  boolean isRegistered=tur.findByTrainingIdAndAccountId(Long.parseLong(tId), ControllerUtil.getUserAccount(ar).getId())!=null;
	  
	  if(!isRegistered)return "redirect:/";
	  
	  StandardQuestionaireForm sqf=new StandardQuestionaireForm();
	  Training t=tr.findById(Integer.parseInt(tId));
	  sqf.setTrainingId(t.getId().longValue());
	  model.addAttribute("sqForm", sqf);
		return "training/Questionnaire";
	}
	
	@RequestMapping(value = "feedback/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute StandardQuestionaireForm sqForm,Principal principal, Model model) {
	  
	  StandardQuestionaire sq=QuestionaireConverter.toStandardQuestionaire(sqForm);
	  sq.setUserId(ControllerUtil.getUserAccount(ar).getId());
	  sqr.save(sq);
	  
	  return "redirect:/";
	}
}