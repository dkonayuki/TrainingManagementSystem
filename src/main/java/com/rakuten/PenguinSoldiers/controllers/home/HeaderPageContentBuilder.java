package com.rakuten.PenguinSoldiers.controllers.home;

import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.admin.AdminRepository;

public class HeaderPageContentBuilder {
  
  public static HeaderPageContent build(AccountRepository ar, AdminRepository adR, String username){
    Account a=ar.findByEmail(username);
    
    HeaderPageContent hpc=new HeaderPageContent();
    hpc.setAdmin(adR.isAdmin(a.getId()));
    hpc.setManager(ar.isManager(a.getUsername()));
    
    return hpc;
  }
  
}
