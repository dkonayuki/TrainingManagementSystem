package com.rakuten.PenguinSoldiers.controllers.admin;

import java.util.List;

import com.rakuten.PenguinSoldiers.models.account.Account;

public class AdminControllerPageContent {
  
  public List<Account> admins;
  
  public String adminList="";
  
  public AdminControllerPageContent(){
    
  }
  
  public void setAdminList(List<Account> admins){
    this.admins=admins;
//    generate();
  }
  
  public String generate(){
    if(admins==null)return "";
    String ret="";
    for(int i=0;i<admins.size();i++){
      ret+=admins.get(i).getName();
    }
    adminList=ret;
    return ret;
  }

}
