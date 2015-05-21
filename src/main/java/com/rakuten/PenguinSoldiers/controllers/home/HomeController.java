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
  
  
  public static final String TRAINING_FILTER_IN="in";
  public static final String TRAINING_FILTER_OUT="out";
  public static final String TRAINING_FILTER_PAST="past";
  
  @Autowired
  private AccountRepository accountRepository;
  
  @Autowired
  private TrainingService trainingService;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(@RequestParam(value = "filter", required = false, defaultValue = "out") String filter, @RequestParam(value = "name", required = false, defaultValue = "%") String name, Principal principal, Model model) {
    
    if (principal != null) {
//      UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////      
//      Account user = accountRepository.findByUsername(userDetails.getUsername());
//
//      List<Training> list=trainingService.findRegsiterdTraining(filter,name,user);
//      
      model.addAttribute("trainings", search(filter,name));
      
      HomePageContent hpc=new HomePageContent();
      hpc.setTrainingTab(filter);
      model.addAttribute("hpc", hpc);
      
      return "home/homeSignedIn";
    }
    return "account/signin";
  }
  
  
  @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD},     
      headers = "x-requested-with=XMLHttpRequest")
  public String search(@RequestParam(value = "filter", required = false, defaultValue = "out") String filter, @RequestParam(value = "name", required = false, defaultValue = "%") String name, Model model) {
//    List<Training> tl = trainingService.findByName(name);
//    model.addAttribute("trainings", tl);
    model.addAttribute("trainings", search(filter,name));
//    HomePageContent hpc=new HomePageContent();
//    hpc.setTrainingTab(filter);
//    model.addAttribute("hpc", hpc);
    return "home/_training_list";
  }
  
  public List<Training> search(String filter, String name){
    UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
    Account user = accountRepository.findByUsername(userDetails.getUsername());
    return trainingService.findRegsiterdTraining(filter,name,user);
  }
}
