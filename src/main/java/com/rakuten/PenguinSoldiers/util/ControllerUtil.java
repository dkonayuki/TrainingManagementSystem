package com.rakuten.PenguinSoldiers.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ControllerUtil {
  
  public static UserDetails getUserDetails(){
    return (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
  }

}
