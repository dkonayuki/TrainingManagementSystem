package com.rakuten.PenguinSoldiers.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ControllerUtil {
  
  public static UserDetails getUserDetails(){
    try{
      return (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }catch(Exception e){
      return null;
    }
  }

}
