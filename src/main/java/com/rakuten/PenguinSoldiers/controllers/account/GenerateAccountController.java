package com.rakuten.PenguinSoldiers.controllers.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.HierarchyRepository;
import com.rakuten.PenguinSoldiers.util.GenerateAccounts;

@Controller
public class GenerateAccountController {
  
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private HierarchyRepository hierarchyRepository;
  
  
  @RequestMapping(value = "generate")
  public String genAccount() {
//    GenerateAccounts.generate(accountRepository);
    return "account/generate";
  }
  
  @RequestMapping(value = "generateOrg")
  public String genOrg() {
//    GenerateAccounts.generateOrg(accountRepository,hierarchyRepository);
    return "account/generate";
  }
}
