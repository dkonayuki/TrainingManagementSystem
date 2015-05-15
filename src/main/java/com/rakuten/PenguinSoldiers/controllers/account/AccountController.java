package com.rakuten.PenguinSoldiers.controllers.account;

import java.security.Principal;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.ChangePassForm;
import com.rakuten.PenguinSoldiers.models.account.ChangePassFormValidator;
import com.rakuten.PenguinSoldiers.models.account.ForgotPassForm;
import com.rakuten.PenguinSoldiers.support.web.MessageHelper;

@Controller
@Secured("ROLE_USER")
class AccountController {

  @Autowired
	private AccountRepository accountRepository;
	
	@Inject
	private PasswordEncoder passwordEncoder;


	@Autowired
	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@RequestMapping(value = "account/current", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public Account accounts(Principal principal) {
		Assert.notNull(principal);
		return accountRepository.findByEmail(principal.getName());
	}
	
	@RequestMapping(value = "account/changePassword", method = RequestMethod.POST)
	public String changePassword(@Validated @ModelAttribute ChangePassForm changePassForm, Principal principal, Model model){
	  Account account=accountRepository.findByUsername(principal.getName());
//	  ChangePassFormValidator cpfv=new ChangePassFormValidator();
//	  cpfv.validate(changePassForm, result);
	  if(account!=null){
	    if(changePassForm.isConfirmed()){
	      if(passwordEncoder.matches(changePassForm.getOldPass(), account.getPassword())){
	        if(!changePassForm.getOldPass().equals(changePassForm.getNewPass())){
	          account.setPassword(passwordEncoder.encode(changePassForm.getNewPass()));
	          accountRepository.update(account);
	          return "redirect:/";
	        }
	      }else{
	        model.addAttribute("oldPassError", "Wrong Old Password.");
	      }
	      
	    }else{
	      MessageHelper.addErrorAttribute(model, "not match");
	      model.addAttribute("cNewPassError", "Not Matched");
	    }
	    
	  }
	  return "account/changePass";
	}
	
	@RequestMapping(value = "account/wantChangePass", method = RequestMethod.GET)
  public String changePassword(Principal principal, Model model){
	  model.addAttribute(new ChangePassForm());
	  return "account/changePass";
	}
	
}
