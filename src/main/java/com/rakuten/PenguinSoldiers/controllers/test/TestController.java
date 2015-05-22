package com.rakuten.PenguinSoldiers.controllers.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.HierarchyRepository;
import com.rakuten.PenguinSoldiers.models.account.UserService;

@Controller
public class TestController {

  @Autowired
  private AccountRepository accountRepository;
  @Autowired
    private HierarchyRepository hierarchyRepository;
    

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/modal")
  public String modal(Model model) {
//    GenerateAccountController gac=new GenerateAccountController();
//    gac.genAccount();
//    GenerateAccounts.generate(accountRepository);
//    GenerateAccounts.generateOrg(accountRepository,hierarchyRepository);
//    gac.genOrg();
//    model.addAttribute(new SignupForm());
    return "./test/__modal_test";
  }
  
}
