package com.rakuten.PenguinSoldiers.models.account;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.validation.Errors;

import com.rakuten.PenguinSoldiers.models.account.ChangePassForm;
import com.rakuten.PenguinSoldiers.support.web.MessageHelper;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.Account;


public class ChangePassValidator {
	
	@Autowired
	private ChangePassForm changePassForm;
	
	@Autowired
	private AccountRepository accountRepository;
	
	//@Inject
	//private PasswordEncoder passwordEncoder;
	StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder();
	
	public void validate(Principal principal, AccountRepository accountRepository, ChangePassForm changePassForm, Errors errors) {
		System.out.println(principal.getName());  
		Account account=accountRepository.findByUsername(principal.getName());
		System.out.println(principal.getName());  
		  if(account!=null)
		  {
			  System.out.println("Account is not null");
			  
			  if(changePassForm.isConfirmed())
			  {

				  if(passwordEncoder.matches(changePassForm.getOldPass(), account.getPassword()))
				  {
					  System.out.println("Old password is right");
					  if(!changePassForm.getOldPass().equals(changePassForm.getNewPass()))
		    		  {
						  if(changePassForm.getNewPass() != null && !changePassForm.getNewPass().isEmpty() && changePassForm.getNewPass().length()!=0)
						  {
							  System.out.println("valid new password");
						      account.setPassword(passwordEncoder.encode(changePassForm.getNewPass()));
		    			      accountRepository.update(account);
						  }
						  else
						  {
							  errors.rejectValue("cNewPass", "Pass.null");
						  }
		    		  }
					  else
					  {
						  errors.rejectValue("oldPass", "samePass.wrong");
					  }
			      }
				  else
			      {
					  System.out.println("Old password is wrong");
					  errors.rejectValue("oldPass", "oldPass.wrong");
				  }
		      }
			  else
			  {
		    	errors.rejectValue("cNewPass", "cNewPass.notEqual");
		      }
		  }
		  else
		  {
			  System.out.println("Account is null");
			  errors.rejectValue("cNewPass","changePass.null");
		  }
	}

}
