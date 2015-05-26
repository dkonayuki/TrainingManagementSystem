package com.rakuten.PenguinSoldiers.controllers.training;

import java.security.Principal;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.turbo.TurboFilter;

import com.rakuten.PenguinSoldiers.controllers.questionnaire.QuestionnaireController;
import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.questionnaire.QuestionnaireListPageContentBuilder;
import com.rakuten.PenguinSoldiers.models.questionnaire.StandardQuestionnairePageContentBuilder;
import com.rakuten.PenguinSoldiers.models.training.RegisterUserForm;
import com.rakuten.PenguinSoldiers.models.training.StandardQuestionnaireRepository;
import com.rakuten.PenguinSoldiers.models.training.TrainingRepository;
import com.rakuten.PenguinSoldiers.models.training.TrainingUser;
import com.rakuten.PenguinSoldiers.models.training.TrainingUserRepository;
import com.rakuten.PenguinSoldiers.util.ControllerUtil;

@Controller
public class TrainingUserController {
  
  @Autowired
  private TrainingUserRepository trainingUserRepository;

  @Autowired
  private TrainingRepository trainingRepository;

  
  @Autowired
  private AccountRepository accountRepository;
  
  @Autowired
  private StandardQuestionnaireRepository sqr;




  @RequestMapping(value = "/manager/manage", method = RequestMethod.GET)
  public String displayForm(@RequestParam("id") String id, Principal principal, Model model) {
    
    Account a=ControllerUtil.getUserAccount(accountRepository);
    if(a!=null&&!accountRepository.isManager(a.getUsername())) return "redirect:/";
    
    TrainingUserManageContent tumc=TrainingUserManageContentBuilder.build(trainingUserRepository, trainingRepository,new Integer(id), a.getId());
    model.addAttribute("tumc", tumc);
    RegisterUserForm ruf=new RegisterUserForm();
    ruf.setTrainingId(id);
    model.addAttribute("regEmployeeForm", ruf);
    return "manager/managerMain";
  }
  
  
  @RequestMapping(value = "manager/addEmployee", method = RequestMethod.GET)
  public String addEmployee(@Validated @ModelAttribute RegisterUserForm regUserForm, Principal principal, Model model) {
    
    Account a=ControllerUtil.getUserAccount(accountRepository);
    if(a!=null&&!accountRepository.isManager(a.getUsername())) return "redirect:/";
    
    addUser(regUserForm, a);
    TrainingUserManageContent tumc=TrainingUserManageContentBuilder.build(trainingUserRepository, trainingRepository,new Integer(regUserForm.getTrainingId()), a.getId());
    model.addAttribute("tumc", tumc);
//    model.addAttribute("id",regUserForm.getTrainingId());
    RegisterUserForm ruf=new RegisterUserForm();
    ruf.setTrainingId(regUserForm.getTrainingId());
    model.addAttribute("regEmployeeForm", ruf);
    return "manager/managerMain";
  }
  
  @RequestMapping(value = "manager/remove", method = RequestMethod.GET)
  public String preUnregEmployee(@RequestParam("id") String id,  Principal principal, Model model) {
    displayForm(id, principal, model);
    return "manager/unRegEmployee";
  }
  
  
  @RequestMapping(value = "manager/removeEmployee", method = RequestMethod.GET)
  public String removeEmployee(@Validated @ModelAttribute RegisterUserForm regUserForm, Principal principal, Model model) {
    
    Account a=ControllerUtil.getUserAccount(accountRepository);
//    addUser(regUserForm, a);
    removeUser(regUserForm, a);
    TrainingUserManageContent tumc=TrainingUserManageContentBuilder.build(trainingUserRepository, trainingRepository,new Integer(regUserForm.getTrainingId()), a.getId());
    model.addAttribute("tumc", tumc);
//    model.addAttribute("id",regUserForm.getTrainingId());
    RegisterUserForm ruf=new RegisterUserForm();
    ruf.setTrainingId(regUserForm.getTrainingId());
    model.addAttribute("regEmployeeForm", ruf);
    
    return "manager/unRegEmployee";
  }
  
  
  @RequestMapping(value = "manager/completed", method = RequestMethod.GET)
  public String showCompletedQuestionnaire(@RequestParam("id") String id, Model model){
    try{
      long trainingId=Long.parseLong(id);
      long userId=ControllerUtil.getUserAccount(accountRepository).getId();
//      sqr.employeeCompleted(trainingId, userId);
      List<Account> completed=trainingUserRepository.findCompletedQuestionnaire(trainingId, userId); 
      model.addAttribute("completed", completed);
      model.addAttribute("training", trainingRepository.findById(Integer.parseInt(id)));
      model.addAttribute("qlpc", QuestionnaireListPageContentBuilder.build(sqr, trainingId, userId));
      
    }catch(Exception e){
      e.printStackTrace();
    }
    return "/manager/completedQuestionnaire";
  }
  
  @RequestMapping(value = "manager/feedback/view", method = {RequestMethod.GET, RequestMethod.HEAD},     
      headers = "x-requested-with=XMLHttpRequest")
  public String search(@RequestParam(value = "id", required = false, defaultValue = "-1") String id, Model model) {
    
    model.addAttribute("sq", StandardQuestionnairePageContentBuilder.build(sqr.findById(new Long(id))));
    
    return "training/_show_q";
  }
  
  private boolean removeUser(RegisterUserForm ruf,Account a){
    if(ruf.getIn()==null||ruf.getIn().size()==0) return false;
    
    for(int i=0;i<ruf.getIn().size();i++){
      TrainingUser tu=trainingUserRepository.findByTrainingIdAndAccountId(new Long(ruf.getTrainingId()), ruf.getIn().get(i));
      if(tu!=null)trainingUserRepository.delete(tu);
    }
    return true;
  }
  
  private boolean addUser(RegisterUserForm ruf,Account a){
    if(ruf.getOut()==null||ruf.getOut().size()==0) return false;
    
    for(int i=0;i<ruf.getOut().size();i++){
      TrainingUser tu=new TrainingUser();
      tu.setUserId(ruf.getOut().get(i));
      tu.setTrainingId(new Long(ruf.getTrainingId()));
      tu.setAddedBy(a.getId());
      if(!trainingUserRepository.isExist(tu))
        trainingUserRepository.save(tu);
    }
    return true;
  }
}
