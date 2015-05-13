package com.rakuten.PenguinSoldiers.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rakuten.PenguinSoldiers.controllers.home.HeaderPageContentBuilder;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.admin.AdminRepository;
import com.rakuten.PenguinSoldiers.util.ControllerUtil;

public class RequestInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  private AdminRepository adminRepository;
  
  @Autowired
  private AccountRepository accountRepository;
  
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception {
    
//    System.out.println("---Before Method Execution---preHandle()");
    return true;
  }
  
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception {
    String username="";
    UserDetails ud=ControllerUtil.getUserDetails();
    if(ud!=null)
      username=ud.getUsername();
    modelAndView.addObject("pageContent",HeaderPageContentBuilder.build(accountRepository, adminRepository, username));
//    System.out.println("---After Method Execution---postHandle()");
  }
  
}
