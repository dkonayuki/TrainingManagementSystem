package com.rakuten.PenguinSoldiers.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.training.TrainingUserRepository;

public class ControllerUtil {
  
  public static UserDetails getUserDetails(){
    try{
      return (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }catch(Exception e){
      return null;
    }
  }
  
  public static Account getUserAccount(AccountRepository ar){
    if(ar==null)return null;
    return ar.findByUsername(getUserDetails().getUsername());
  }
}
