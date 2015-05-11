package com.rakuten.PenguinSoldiers.controllers.training;

import javax.persistence.Lob;



import java.sql.Blob;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.Admin;
import com.rakuten.PenguinSoldiers.models.account.AdminRepository;
import com.rakuten.PenguinSoldiers.models.account.UserService;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;



import com.rakuten.PenguinSoldiers.util.DateTimeUtil;

import java.lang.String;

@Controller
public class AdminController {
	@Autowired
	private TrainingService trainingService;
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private AdminRepository adminRepository;
	@Autowired
  private UserService userService;
  
	
	@RequestMapping(value = "addTrainingPrograms", method=RequestMethod.GET)
	public String addTrainingPrograms()
	{
		return "admin/addTrainingPrograms";
	}

	@Lob
	private String overview;
	@RequestMapping(value = "addAction", method = RequestMethod.GET)
	public String addAction(@RequestParam("name") String Name, @RequestParam("overview") String overview, @RequestParam("goal") String goal, @RequestParam("date") String date, @RequestParam("target") String target, @RequestParam("participantNum") int participantNum, @RequestParam("duedate") String duedate, @RequestParam("venue") String venue, ModelMap model)
	{
		Training tr = new Training(Name);
		tr.setOverview(overview);
		tr.setMax_participants(participantNum);
		//tr.setDue_date(duedate);
		trainingService.save(tr);
		return "home/homeSignedIn";
	}
	
	
	/*
	 * check if user is admin
	 * check if newAdmin is not admin
	 * 
	 * 
	 */
	
	@RequestMapping(value = "addAdmin", method = RequestMethod.GET)
  public String addAdmin(@RequestParam("newAdminId") String newAdminId){
	  
	  UserDetails userDetails =
	      (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  
	  Account a=accountRepository.findByUsername(userDetails.getUsername());
	  if(adminRepository.isAdmin(a.getId())){
	    Account newAdmin=accountRepository.findById(new Long(newAdminId));
	    Admin admin=new Admin();
	    admin.setUserId(newAdmin.getId());
	    admin.setAddedBy(a.getId());
	    admin.setAddedOn(DateTimeUtil.getNow());
	    
	    adminRepository.addAdmin(admin);
	  }
	  
	  
	  return null;
	}
      
	
	
}
