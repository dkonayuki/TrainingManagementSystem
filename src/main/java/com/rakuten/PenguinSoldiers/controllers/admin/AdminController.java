package com.rakuten.PenguinSoldiers.controllers.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.admin.Admin;
import com.rakuten.PenguinSoldiers.models.admin.AdminRepository;
import com.rakuten.PenguinSoldiers.models.admin.NewAdminValidator;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;
import com.rakuten.PenguinSoldiers.models.training.TrainingValidator;
import com.rakuten.PenguinSoldiers.util.DateTimeUtil;

import java.lang.String;

import javax.validation.Valid;

@Controller
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TrainingService trainingService;
	
	public void init(Model model){
	  AdminControllerPageContent acpc=new AdminControllerPageContent();
	  acpc.setAdminList(accountRepository.listAdmins());
	  model.addAttribute("acpc",acpc);
	}
	
	@RequestMapping(value = "admin/addAdmin", method = RequestMethod.GET)
  public String addAdmin(@RequestParam("newAdminId") String newAdminId, Model model){
    
    UserDetails userDetails =
        (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
    
    Account a=accountRepository.findByUsername(userDetails.getUsername());//change to username
    //check if user is admin
    if(adminRepository.isAdmin(a.getId())){
      //check if new admin is eligible
      Account newAdmin=accountRepository.findByUsername(newAdminId); 
      
	  if(newAdmin==null){

      }else{
        Admin admin=new Admin();
        admin.setUserId(newAdmin.getId());
        admin.setAddedBy(a.getId());
        admin.setAddedOn(DateTimeUtil.getNow());
        adminRepository.addAdmin(admin);
      }
    }
    init(model);
    return "admin/addAdminPage";
  }
	@RequestMapping(value = "admin/addAdminPage", method = RequestMethod.GET)
	public String addAdminPage(Model model) {
	  init(model);
		return "admin/addAdminPage";
	}
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String admin(Model model) {
		
		model.addAttribute("trainings", trainingService.findAll());
		return "admin/adminMain";
	}
}
