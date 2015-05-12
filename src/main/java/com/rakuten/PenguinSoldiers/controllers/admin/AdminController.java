package com.rakuten.PenguinSoldiers.controllers.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.admin.Admin;
import com.rakuten.PenguinSoldiers.models.admin.AdminRepository;
import com.rakuten.PenguinSoldiers.util.DateTimeUtil;

import java.lang.String;

@Controller
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
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
	@RequestMapping(value = "admin/addAdminPage", method = RequestMethod.GET)
	public String addAdminPage() {
		return "admin/addAdminPage";
	}
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String admin() {
		return "admin/adminMain";
	}
}
