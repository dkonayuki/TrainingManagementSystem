package com.rakuten.PenguinSoldiers.controllers.home;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;

@Controller
public class HomeController {
  
  @Autowired
  private AccountRepository accountRepository;
  
  @Autowired
  private TrainingService trainingService;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(@RequestParam(value = "filter", required = false, defaultValue = "in") String filter, Principal principal, Model model) {
    
    if (principal != null) {
      UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//      
      Account user = accountRepository.findByUsername(userDetails.getUsername());

      List<Training> list=trainingService.findRegsiterdTraining(filter.equals("in"),user);
      model.addAttribute("trainings", list);
      
      HomePageContent hpc=new HomePageContent();
      hpc.setTrainingTab(filter);
      model.addAttribute("hpc", hpc);
      
      return "home/homeSignedIn";
    }
    return "account/signin";
  }
}
